from .auxillary.glob import glob


def sort(args, pipeArg):
    result = []
    lines = []
    if pipeArg:
        pipeArg = '\n'.join(pipeArg)
        lines = pipeArg.splitlines()
        result = sorted(lines, key=None, reverse=False)
        return result
    if len(args) == 0:
        try:
            while 1:
                inp = input()
                print(inp)
        except KeyboardInterrupt:
            print()
            return
    args = glob(None, None, args, True)
    reverse = False
    if args[0] == '-r':
        args.pop(0)
        reverse = True

    words = []
    for file_path in args:
        try:
            f = open(file_path, 'r')
            for line in f:
                words.append(line.strip())
            f.close()
            if reverse:
                result = sorted(words, key=None, reverse=True)
            else:
                result = sorted(words, key=None, reverse=False)
        except FileNotFoundError:
            raise FileNotFoundError(
                f"sort: {file_path}: no such file or directory \n")
    return result
