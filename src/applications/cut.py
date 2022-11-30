from .auxillary.glob import glob


def cut(args, pipeArg):
    bytes_list = []
    if pipeArg:
        for arg in pipeArg:
            args.append(arg)
    if len(args) == 0:
        raise ValueError("cut: no arguments specified \n")
    else:
        if args[0] == '-b':
            try:
                args.pop(0)
                bytes_list = "".join(args.pop(0)).split(",")

            except IndexError:
                raise IndexError(
                    "cut: option requires an argument -- b \n")

    result = []
    fs = None
    lines = []
    tmp = []
    args = glob(None, None, args, True)
    for file_path in args:
        try:
            if pipeArg:
                lines = file_path.splitlines()
            else:
                f = open(file_path, 'r')
                if fs is None:
                    fs = file_path
                if fs != file_path:
                    result.append('')
                lines = f.read().splitlines()
                f.close()
            for line in lines:
                if line.isspace() or line == "":
                    result.append(line)
                    continue
                # encode line to be able to cut accurate bytes
                s = line.encode("utf8")
                lowc = 0
                highc = 0
                for index, x in enumerate(bytes_list):
                    try:
                        if any(chara in ['-'] for chara in x):
                            # checks for byte pattern commencing with -... eg -7
                            if x[0] == "-":
                                if highc == 0:
                                    tmp.append(s[:int(x.split("-")[1])])
                                    high = int(x.split("-")[1])
                                    changehigh = index
                                    highc += 1
                                else:
                                    if int(x.split("-")[1]) > high:
                                        high = int(x.split("-")[1])
                                        tmp[changehigh] = s[:int(
                                            x.split("-")[1])]
                                        tmp[changehigh] = tmp[changehigh].decode(
                                            "utf8")

                                        continue
                                    else:
                                        continue
                            # checks for byte pattern commencing with ...- eg 6-
                            elif x[len(x)-1] == "-" or int(x.split("-")[1]) > len(s):
                                if lowc == 0:
                                    tmp.append(s[int(x.split("-")[0])-1:])
                                    low = int(x.split("-")[0])-1
                                    changelow = index
                                    lowc += 1
                                else:
                                    if int(x.split("-")[0])-1 < low:
                                        low = int(x.split("-")[0])-1
                                        tmp[changelow] = s[int(
                                            x.split("-")[0])-1:]
                                        tmp[changelow] = tmp[changelow].decode(
                                            "utf8")
                                        continue
                                    else:
                                        continue
                            # check for range when bith low and high given. eg 3-6
                            else:
                                tmp.append(
                                    s[int(x.split("-")[0])-1:int(x.split("-")[1])])
                        else:
                            # check for single bytes
                            a = s.decode("utf8")[int(x)-1]
                            tmp.append(a.encode("utf8"))
                    except ValueError:
                        raise ValueError(
                            "cut: illegal input \n")
                    tmp[index] = tmp[index].decode("utf8")
                result.append("".join(tmp))
                tmp.clear()

        except FileNotFoundError:
            raise FileNotFoundError(
                f"cut: {file_path}: no such file or directory \n")
    return result
