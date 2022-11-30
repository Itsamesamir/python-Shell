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
            f = open(file_path, 'r')
            content = f.read()
            f.close()
            result.append(content[:-1])
        except FileNotFoundError:
            raise FileNotFoundError(
                f"cat: {file_path}: no such file or directory \n")
        except IsADirectoryError:
            result.append(f"cat: {file_path}: is a directory")
        except UnicodeDecodeError:
            raise UnicodeDecodeError(
                f"cat: {file_path}: is a binary file \n")
    return result
