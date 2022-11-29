import os
from .auxillary.glob import glob


def head(args, pipeArg):
    index = 10
    if len(args) == 0:
        pass
    else:
        if args[0] == '-n':
            try:
                index = int(args[1])
                if index < 0:
                    raise TypeError(f"head: illegal line count -- {index}")
                args.pop(0)
                args.pop(0)
            except IndexError:
                raise TypeError(f"head: option requires an arguement -- n")
            except ValueError:
                raise TypeError(
                    f"head: illegal line count -- \'{args[1]}\'")

    args = glob(None, None, args, True)

    if len(args) == 0:
        if pipeArg:
            for n in pipeArg:
                args.append(n)
        else:
            try:
                counter = 0
                while counter < index:
                    inp = input()
                    print(inp)
                    counter += 1
                print()
            except KeyboardInterrupt:
                print()
                return

    result = []
    fs = None
    for file_path in args:
        try:
            if pipeArg:
                lines = file_path.splitlines()
            else:
                if os.path.isdir(file_path):
                    result.append(
                        f"cat: {file_path}: is a directory")
                    continue
                f = open(file_path, 'r')
                if fs == None:
                    fs = file_path
                if fs != file_path:
                    result.append('')
                lines = f.read().splitlines()
                f.close()
                if len(args) > 1:
                    result.append(f"==> {file_path} <==")
            for line in lines[:index]:
                result.append(line)
        except FileNotFoundError:
            result.append(f"head: {file_path}: no such file or directory")
    return result
