from .auxillary.glob import glob


def echo(args, pipeArg):
    result = []
    args = glob(None, None, args, True)
    for m in range(0, len(args)):
        tmp = list(args[m])
        n = 0
        while n < len(tmp):
            if tmp[n] == '\\':
                tmp.pop(n)
            n += 1
        tmp = ''.join(tmp)
        result.append(tmp)
    result = ' '.join(result)
    return [result]
