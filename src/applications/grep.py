import os
import re
from .auxillary.glob import glob


def grep(args, pipeArg):
    if len(args) == 0:
        raise ValueError("grep: too few arguments specified \n")
    elif len(args) == 1:
        if pipeArg:
            for n in pipeArg:
                args.append(n)
        else:
            try:
                while 1:
                    input()
            except KeyboardInterrupt:
                print()
                return
    result = []
    pattern = args[0]
    args.pop(0)
    args = glob(None, None, args, True)
    for file_path in args:
        try:
            if pipeArg:
                lines = file_path.splitlines()
            else:
                if os.path.isdir(file_path):
                    result.append(
                        f"grep: {file_path}: is a directory")
                    continue
                f = open(file_path, 'r')
                lines = f.read().splitlines()
                f.close()
            for line in lines:
                match = re.search(pattern, line)
                if match:
                    if len(args) == 1:
                        result.append(line)
                    elif pipeArg:
                        result.append(line)
                    else:
                        result.append(f"{file_path}:{line}")
        except FileNotFoundError:
            raise FileNotFoundError(
                f"grep: {file_path}: no such file or directory \n")
    return result
