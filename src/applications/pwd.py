import os


def pwd(args, pipeArg):
    if len(args) > 0:
        raise ValueError("pwd: too many arguments")
    return [os.getcwd()]
