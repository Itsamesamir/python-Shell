import os


def cd(args, pipeArg):
    if len(args) > 1:
        raise ValueError(f"cd: string not in pwd: {args[0]} \n")
    try:
        if len(args) == 0:
            os.chdir('/')
        else:
            os.chdir(args[0])
    except FileNotFoundError:
        raise FileNotFoundError(f"cd: no such file or directory {args[0]} \n")
