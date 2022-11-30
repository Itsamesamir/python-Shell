from .auxillary.glob import glob


def cut(args, pipeArg):
    bytes_list = []
    if pipeArg:
        for arg in pipeArg:
            args.append(arg)
    if len(args) == 0:
        raise ValueError(f"cut: no arguments specified \n")
    else:
        if args[0] == '-b':
            try:
                args.pop(0)
                bytes_list = "".join(args.pop(0)).split(",")

            except IndexError:
                raise IndexError(
                    f"cut: option requires an argument -- b \n")
            except ValueError:
                raise ValueError(
                    f"cut: illegal line count \n")
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
                if fs == None:
                    fs = file_path
                if fs != file_path:
                    result.append('')
                lines = f.read().splitlines()
                f.close()
            for line in lines:
                if line.isspace() or line == "":
                    result.append(line)
                    continue
                s = line.encode("utf8")
                lowc = 0
                highc = 0
                for index, x in enumerate(bytes_list):

                    if any(chara in ['-'] for chara in x):
                        if x[0] == "-":
                            if highc == 0:
                                tmp.append(s[:int(x.split("-")[1])])
                                high = int(x.split("-")[1])
                                changehigh = index
                                highc += 1
                            else:
                                if int(x.split("-")[1]) > high:
                                    high = int(x.split("-")[1])
                                    tmp[changehigh] = s[:int(x.split("-")[1])]
                                    tmp[changehigh] = tmp[changehigh].decode(
                                        "utf8")

                                    continue
                                else:
                                    continue
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

                        else:
                            tmp.append(
                                s[int(x.split("-")[0])-1:int(x.split("-")[1])])
                    else:
                        a = s.decode("utf8")[int(x)-1]
                        tmp.append(a.encode("utf8"))

                    tmp[index] = tmp[index].decode("utf8")
                result.append("".join(tmp))
                tmp.clear()

        except FileNotFoundError:
            raise FileNotFoundError(
                f"head: {file_path}: no such file or directory \n")
    return result
