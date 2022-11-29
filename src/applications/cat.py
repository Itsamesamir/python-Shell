import os
from .auxillary.glob import glob


def cat(args, pipeArg):
    result = []
    content = None
    if len(args) == 0:
        if pipeArg:
            result.append(pipeArg[0])
            return result
        try:
            while 1:
                inp = input()
                print(inp)
        except KeyboardInterrupt:
            print()
            return
    args = glob(None, None, args, True)
    for file_path in args:
        try:
            if os.path.isdir(file_path):
                result.append(
                    f"cat: {file_path}: is a directory")
                continue
            f = open(file_path, 'r')
            content = f.read()
            f.close()
            result.append(content[:-1])
        except FileNotFoundError:
            result.append(
                f"cat: {file_path}: no such file or directory")
        except UnicodeDecodeError:
            result.append(
                f"cat: {file_path}: is a binary file")
    return result
