import os
import re


def glob(pattern=None, path=None, args=None, basic=False):
    result = []
    if args:
        for n in range(0, len(args)):
            if '*' in args[n]:
                result = result + glob(args[n], None, None, True)
            else:
                result.append(args[n])
        return result
    if not pattern:
        return result
    pattern = list(pattern)
    n = 0
    while n < len(pattern):
        if pattern[n] in ['^', '$', '.', '|', '?', '+', '(', ')', '[', ']', '{', '}']:
            pattern[n] = '\\' + pattern[n]
        if pattern[n] == '*':
            if os.path.isdir(''.join(pattern[:n])):
                path = ''.join(pattern[:n])
                del pattern[:n]
                n = 0
            pattern[n] = '.*'
        n += 1
    if '.*' not in pattern:
        pattern.insert(0, '^')
    pattern.append('$')
    pattern = ''.join(pattern)
    if not path:
        path = './'
    if basic:
        for fileName in os.listdir(path):
            if re.search(pattern, fileName):
                if path == './':
                    result.append(fileName)
                else:
                    result.append(os.path.join(path, fileName))
    else:
        for dName, sdName, fList in os.walk(path):
            if pattern:
                for fileName in fList:
                    if re.search(pattern, fileName):
                        result.append(os.path.join(dName, fileName))
            else:
                for fileName in fList:
                    result.append(os.path.join(dName, fileName))
    return result
