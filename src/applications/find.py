import os
from .auxillary.glob import glob


def find(args, pipeArg):
    pattern = None
    if len(args) == 0:
        raise TypeError("find: please enter a file path or pattern")
    if len(args) > 1:
        if args[1] == '-name':
            if len(args) == 2:
                raise TypeError(
                    "find: -name requires additional arguements")
            elif len(args) > 3:
                raise TypeError(
                    f"find: {args[3]}: unkown primary or operator")
        elif args[0] == '-name':
            args.insert(0, './')
        else:
            raise TypeError("find: too many arguements")
    if len(args) == 1:
        if args[0] == '-name':
            print("find: illegal option --n")
        else:
            args.append('-name')
            args.append('*')

    result = []
    pattern = args[-1]
    args = glob(None, None, args[:-2], True)
    args.append('-name')
    args.append(pattern)
    for filepath in args[:-2]:
        if os.path.exists(filepath):
            for n in glob(pattern, filepath):
                result.append(n)
            if len(result) == 0:
                result.append(f"find: no matches found: {pattern}")
        else:
            raise TypeError(f"find: {filepath}: no such file or directory")
    return result
