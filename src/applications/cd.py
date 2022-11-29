import os


def cd(args, pipeArg):
    if len(args) > 1:
        raise TypeError(f"cd: string not in pwd: {args[0]}")
    try:
        if len(args) == 0:
            os.chdir('/')
        else:
            os.chdir(args[0])
    except FileNotFoundError:
        raise TypeError(f"cd: no such file or directory {args[0]}")
