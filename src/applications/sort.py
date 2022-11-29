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

    words = []
    for file_path in args:
        try:
            f = open(file_path, 'r')
            for line in f:
                words.append(line.strip())
            f.close()
            result = sorted(words, key=None, reverse=False)
            if args[0] == '-r':
                result = sorted(words, key=None, reverse=True)
        except FileNotFoundError:
            result.append(
                f"sort: {file_path}: no such file or directory")
    return result
