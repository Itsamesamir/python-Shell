import os
from .auxillary.glob import glob


def ls(args, pipeArg):
    if len(args) == 0:
        ls_dir = [os.getcwd()]
    else:
        ls_dir = glob(None, None, args, True)
    try:
        result = []
        for path in ls_dir:
            if len(args) > 1:
                result.append(
                    f"\033[1;36;40m{path.split('/')[-1]}:\033[1;37;40m")
            if os.path.isdir(path):
                for f in os.listdir(path):
                    if f[0] == '.':
                        continue
                    else:
                        result.append(f)
            else:
                raise FileNotFoundError(
                    f"ls: no such file or directory {path} \n")

            if len(args) > 1:
                result.append('')

        if result and result[-1] == '':
            result.pop()
        return result
    except FileNotFoundError:
        raise FileNotFoundError(f"ls: no such file or directory {path} \n")
