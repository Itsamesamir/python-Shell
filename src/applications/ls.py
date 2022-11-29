import os
from .auxillary.glob import glob


def ls(args, pipeArg):
    if len(args) == 1:
        ls_dir = glob(None, None, args, True)
    elif len(args) > 1:
        raise TypeError(f"ls: string not in pwd: {args[0]}")
    else:
        ls_dir = [os.getcwd()]
    try:
        result = []
        for path in ls_dir:
            if os.path.isdir(path):
                for f in os.listdir(path):
                    if f[0] == '.':
                        continue
                    else:
                        result.append(f)
            else:
                raise TypeError(f"ls: no such file or directory {path}")
        return result
    except FileNotFoundError:
        raise TypeError(f"ls: no such file or directory {args[0]}")
