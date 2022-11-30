from .auxillary.glob import glob


def uniq(args, pipeArg):
    case = False
    if len(args) == 0:
        pass
    else:
        if args[0] == '-i':
            case = True
            args.pop(0)

    if len(args) == 0:
        if pipeArg:
            args.append("\n".join(pipeArg))
        else:
            try:
                while 1:
                    inp = input()
                    print(inp)
            except KeyboardInterrupt:
                print()
                return

    args = glob(None, None, args, True)

    # Returns all lines of a file that are adjacently distinct to each other (case insensitive if specified)
    try:
        if pipeArg:
            lines = args[0].splitlines()
        else:
            f = open(args[0], 'r')
            lines = f.read().splitlines()
            f.close()
        if case:
            n = 0
            while len(lines)-1 > n:
                if lines[n].lower() == lines[n+1].lower():
                    lines.pop(n+1)
                    continue
                n += 1
        else:
            n = 0
            while len(lines)-1 > n:
                if lines[n] == lines[n+1]:
                    lines.pop(n)
                    continue
                n += 1

        return [line for line in lines]
    except FileNotFoundError:
        raise FileNotFoundError(
            f"uniq: {args[0]}: no such file or directory \n")
