import os
import re
import sys

from antlr4 import *

from dist.ShellGrammarLexer import ShellGrammarLexer

APPLICATIONS = ['pwd', 'cd', 'echo', 'ls', 'cat', 'head',
                'tail', 'grep', 'find', 'sort', 'cut', 'uniq', 'exit']


class operator():
    def __init__(self, inp):
        data = InputStream(inp)
        lexer = ShellGrammarLexer(data)
        stream = CommonTokenStream(lexer)
        stream.fill()
        stream = stream.tokens
        self.textList = [token.text for token in stream[:-1]]
        self.indexList = [token.tokenIndex for token in stream[:-1]]
        self.typeList = [token.type for token in stream[:-1]]
        self.cycle = 0

    # APPLICATIONS
    def pwd(self, args, argTypes, pipeArg):
        if len(args) > 0:
            raise TypeError("pwd: too many arguments")
        return [os.getcwd()]

    def exit(self, args, argTypes, pipeArg):
        print()
        sys.exit(0)

    def cd(self, args, argTypes, pipeArg):
        if len(args) > 1:
            raise TypeError(f"cd: string not in pwd: {args[0]}")
        try:
            if len(args) == 0:
                os.chdir('/')
            else:
                os.chdir(args[0])
        except FileNotFoundError:
            raise TypeError(f"cd: no such file or directory {args[0]}")

    def echo(self, args, argTypes, pipeArg):
        if not args:
            if len(self.textList) > self.cycle+1:
                if len(self.textList[self.cycle+1]) == 1 and self.textList[self.cycle+1][0] in APPLICATIONS:
                    args = [self.textList[self.cycle+1][0]]
                    self.cycle += 1
        result = []
        args = self.glob(None, None, args, True)
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

    def ls(self, args, argTypes, pipeArg):
        if len(args) == 1:
            ls_dir = self.glob(None, None, args, True)
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

    def cat(self, args, argTypes, pipeArg):
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
        args = self.glob(None, None, args, True)
        for file_path in args:
            try:
                if os.path.isdir(file_path):
                    result.append(
                        f"cat: {file_path}: is a directory")
                    continue
                f = open(file_path, 'r')
                content = f.read()
                f.close()
                result.append(content[:-1])
            except FileNotFoundError:
                result.append(
                    f"cat: {file_path}: no such file or directory")
            except UnicodeDecodeError:
                result.append(
                    f"cat: {file_path}: is a binary file")
        return result

    def head(self, args, argTypes, pipeArg):
        index = 10
        if len(args) == 0:
            pass
        else:
            if args[0] == '-n':
                try:
                    index = int(args[1])
                    if index < 0:
                        raise TypeError(f"head: illegal line count -- {index}")
                    args.pop(0)
                    args.pop(0)
                except IndexError:
                    raise TypeError(f"head: option requires an arguement -- n")
                except ValueError:
                    raise TypeError(
                        f"head: illegal line count -- \'{args[1]}\'")

        args = self.glob(None, None, args, True)

        if len(args) == 0:
            if pipeArg:
                for n in pipeArg:
                    args.append(n)
            else:
                try:
                    counter = 0
                    while counter < index:
                        inp = input()
                        print(inp)
                        counter += 1
                    print()
                except KeyboardInterrupt:
                    print()
                    return

        result = []
        fs = None
        for file_path in args:
            try:
                if pipeArg:
                    lines = file_path.splitlines()
                else:
                    if os.path.isdir(file_path):
                        result.append(
                            f"cat: {file_path}: is a directory")
                        continue
                    f = open(file_path, 'r')
                    if fs == None:
                        fs = file_path
                    if fs != file_path:
                        result.append('')
                    lines = f.read().splitlines()
                    f.close()
                    if len(args) > 1:
                        result.append(f"==> {file_path} <==")
                for line in lines[:index]:
                    result.append(line)
            except FileNotFoundError:
                result.append(f"head: {file_path}: no such file or directory")
        return result

    def tail(self, args, argTypes, pipeArg):
        index = -10
        if len(args) == 0:
            pass
        else:
            if args[0] == '-n':
                try:
                    index = int(args[1])
                    args.pop(0)
                    args.pop(0)
                    if index > 0:
                        index *= -1
                except IndexError:
                    raise TypeError(f"tail: option requires an arguement -- n")
                except ValueError:
                    raise TypeError(f"tail: illegal line count \'{args[1]}\'")

        args = self.glob(None, None, args, True)

        if len(args) == 0:
            if pipeArg:
                for n in pipeArg:
                    args.append(n)
            else:
                try:
                    while 1:
                        inp = input()
                        print(inp)
                except KeyboardInterrupt:
                    print()
                    return

        result = []
        fs = None
        for file_path in args:
            try:
                if pipeArg:
                    lines = file_path.splitlines()
                else:
                    if os.path.isdir(file_path):
                        result.append(
                            f"cat: {file_path}: is a directory")
                        continue
                    f = open(file_path, 'r')
                    if fs == None:
                        fs = file_path
                    if fs != file_path:
                        result.append(' ')
                    lines = f.read().splitlines()
                    f.close()
                    if len(args) > 1:
                        result.append(f"==> {file_path} <==")
                if index == 0:
                    pass
                else:
                    for line in lines[index:]:
                        result.append(line)
            except FileNotFoundError:
                result.append(f"head: {file_path}: no such file or directory")
        return result

    def grep(self, args, argTypes, pipeArg):
        if len(args) == 0:
            print("grep: no arguments were entered")
            return
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
        args = self.glob(None, None, args, True)
        for file_path in args:
            try:
                if pipeArg:
                    lines = file_path.splitlines()
                else:
                    if os.path.isdir(file_path):
                        result.append(
                            f"cat: {file_path}: is a directory")
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
                result.append(
                    f"grep: {file_path}: no such file or directory")
        return result

    def uniq(self, args, argTypes, pipeArg):
        case = False
        if len(args) == 0:
            pass
        else:
            if args[0] == '-i':
                case = True
                args.pop(0)

        if len(args) == 0:
            if pipeArg:
                args.append("\n".join(pipeArg))
            else:
                try:
                    while 1:
                        inp = input()
                        print(inp)
                except KeyboardInterrupt:
                    print()
                    return

        if len(args) > 1:
            raise TypeError(f"uniq: too many arguments")
        else:
            try:
                if pipeArg:
                    lines = args[0].splitlines()
                else:
                    f = open(args[0], 'r')
                    lines = f.read().splitlines()
                    f.close()
                if case:
                    n = 0
                    while len(lines)-1 > n:
                        if lines[n].lower() == lines[n+1].lower():
                            lines.pop(n+1)
                            continue
                        n += 1
                else:
                    n = 0
                    while len(lines)-1 > n:
                        if lines[n] == lines[n+1]:
                            lines.pop(n)
                            continue
                        n += 1

                return [line for line in lines]
            except FileNotFoundError:
                raise TypeError(f"uniq: {args[0]}: no such file or directory")

    def find(self, args, argTypes, pipeArg):
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
        args = self.glob(None, None, args[:-2], True)
        args.append('-name')
        args.append(pattern)
        for filepath in args[:-2]:
            if os.path.exists(filepath):
                for n in self.glob(pattern, filepath):
                    result.append(n)
                if len(result) == 0:
                    result.append(f"find: no matches found: {pattern}")
            else:
                raise TypeError(f"find: {filepath}: no such file or directory")
        return result

    def sort(self, args, argTypes, pipeArg):
        result = []
        lines = []
        if pipeArg:
            pipeArg = '\n'.join(pipeArg)
            lines = pipeArg.splitlines()
            result = sorted(lines, key=None, reverse=False)
            return result
        if len(args) == 0:
            try:
                while 1:
                    inp = input()
                    print(inp)
            except KeyboardInterrupt:
                print()
                return
        args = self.glob(None, None, args, True)

        words = []
        for file_path in args:
            try:
                f = open(file_path, 'r')
                for line in f:
                    words.append(line.strip())
                f.close()
                result = sorted(words, key=None, reverse=False)
                if args[0] == '-r':
                    result = sorted(words, key=None, reverse=True)
            except FileNotFoundError:
                result.append(
                    f"sort: {file_path}: no such file or directory")
        return result

    def cut(self, args, argTypes, pipeArg):
        bytes_list = []
        if pipeArg:
            for arg in pipeArg:
                args.append(arg)
        if len(args) == 0:
            pass
        else:
            if args[0] == '-b':
                try:
                    args.pop(0)
                    bytes_list = "".join(args.pop(0)).split(",")

                except IndexError:
                    raise TypeError(
                        f"cut: option requires an argument -- n \n")
                except ValueError:
                    raise TypeError(
                        f"cut: illegal line count \'{args[1]}\' \n")
        result = []
        fs = None
        lines = []
        tmp = []
        for file_path in args:
            try:
                if pipeArg:
                    lines = file_path.splitlines()
                else:
                    f = open(file_path, 'r')
                    if fs == None:
                        fs = file_path
                    if fs != file_path:
                        result.append('')
                    lines = f.read().splitlines()
                    f.close()
                for line in lines:
                    if line.isspace() or line == "":
                        result.append(line)
                        continue
                    s = line.encode("utf8")
                    lowc = 0
                    highc = 0
                    for index, x in enumerate(bytes_list):

                        if any(chara in ['-'] for chara in x):
                            if x[0] == "-":
                                if highc == 0:
                                    tmp.append(s[:int(x.split("-")[1])])
                                    high = int(x.split("-")[1])
                                    changehigh = index
                                    highc += 1
                                else:
                                    if int(x.split("-")[1]) > high:
                                        high = int(x.split("-")[1])
                                        tmp[changehigh] = s[:int(
                                            x.split("-")[1])]
                                        changehigh = index
                                    else:
                                        continue
                            elif x[len(x)-1] == "-" or int(x.split("-")[1]) > len(s):
                                if lowc == 0:
                                    tmp.append(s[int(x.split("-")[0])-1:])
                                    low = int(x.split("-")[0])-1
                                    changelow = index
                                    lowc += 1
                                else:
                                    if int(x.split("-")[0])-1 < low:
                                        low = int(x.split("-")[0])-1
                                        tmp[changelow] = s[int(
                                            x.split("-")[0])-1:]
                                        changelow = index
                                    else:
                                        continue

                            else:
                                tmp.append(
                                    s[int(x.split("-")[0])-1:int(x.split("-")[1])])
                        else:
                            a = s.decode("utf8")[int(x)-1]
                            tmp.append(a.encode("utf8"))

                        tmp[index] = tmp[index].decode("utf8")
                    result.append("".join(tmp))
                    tmp.clear()

            except FileNotFoundError:
                result.append(f"head: {file_path}: no such file or directory")
        return result

    # EVALUATION

    def formatStream(self):
        text_list = []
        type_list = []
        tmp1 = []
        tmp2 = []
        for n in range(0, len(self.textList)):
            if self.textList[n] in [';', '|', '<', '>']:
                if len(tmp1) != 0:
                    text_list.append(tmp1.copy())
                    type_list.append(tmp2.copy())
                    tmp1.clear()
                    tmp2.clear()
                text_list.append(self.textList[n])
                type_list.append(self.typeList[n])
            else:
                if (self.textList[n] == "\'") or (self.textList[n] == "\"") or (self.textList[n] == "`"):
                    try:
                        while 1:
                            inp = input()
                    except KeyboardInterrupt:
                        print('\n')
                        return
                if self.typeList[n] in [18, 19, 20]:
                    tmp1.append(self.textList[n][1:-1])
                    tmp2.append(self.typeList[n])
                elif 0 < self.typeList[n] < 14:
                    if len(tmp1) != 0:
                        text_list.append(tmp1.copy())
                        type_list.append(tmp2.copy())
                        tmp1.clear()
                        tmp2.clear()
                    tmp1.append(self.textList[n])
                    tmp2.append(self.typeList[n])
                else:
                    tmp1.append(self.textList[n])
                    tmp2.append(self.typeList[n])
        if len(tmp1) != 0:
            text_list.append(tmp1)
            type_list.append(tmp2)
        return [text_list, type_list]

    def runApp(self, text_list, type_list, pipeArg=None):
        if text_list[self.cycle][0] in APPLICATIONS:
            tmp = eval(
                'self.'+text_list[self.cycle][0]+'('+str(text_list[self.cycle][1:])+','+str(type_list[self.cycle][1:])+','+str(pipeArg)+')')
            return tmp
        else:
            print(
                f"COMP0010 shell: command not found: {text_list[self.cycle][0]}")
            return

    def comSub(self, text_list, type_list):
        for n in range(0, len(text_list[self.cycle])):
            if type_list[self.cycle][n] == 20:
                tmp_opp = operator(text_list[self.cycle][n])
                tmp_result = tmp_opp.run(True)
                text_list[self.cycle][n] = tmp_result[0]
            if type_list[self.cycle][n] == 19:
                if '`' not in text_list[self.cycle][n]:
                    continue
                else:
                    backq_split = text_list[self.cycle][n].split('`')
                    count = 1
                    while len(backq_split) > count:
                        tmp_opp = operator(backq_split[count])
                        tmp_result = tmp_opp.run(True)
                        backq_split[count] = tmp_result[0]
                        count += 2
                    text_list[self.cycle][n] = ''.join(backq_split)

    def glob(self, pattern=None, path=None, args=None, basic=False):
        result = []
        if args:
            for n in range(0, len(args)):
                if '*' in args[n]:
                    result = result + self.glob(args[n], None, None, True)
                else:
                    result.append(args[n])
            return result
        if not pattern:
            return result
        for n in range(0, len(self.typeList[self.cycle])):
            if (self.textList[self.cycle][n] == pattern):
                if (self.textList[self.cycle][0] != 'find') and (self.typeList[self.cycle][n] == 19 or self.typeList[self.cycle][n] == 18):
                    result.append(self.textList[self.cycle][n])
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

    def returnOutput(self, output):
        if output:
            for args in output:
                print(args)
        else:
            pass

    def run(self, hidden=False):
        # Check if stdrin is empty and if it is end the execution of the function
        if len(self.textList) == 0:
            return

        # Segments tokens into groups seperated by sequences, pipes, or redirections (formats the stream input)
        output = self.formatStream()
        if output:
            text_list = output[0]
            type_list = output[1]
            self.textList = text_list.copy()
            self.typeList = type_list.copy()
        else:
            return

        # Processes the actual stream input and applies logic based on class defined functions above
        tmp = None
        while len(text_list) > self.cycle:
            if text_list[0] == '<':
                if len(text_list) < 2:
                    print("Expected arguement after redirection \n")
                    return
                else:
                    try:
                        f = open(text_list[self.cycle+1][0], 'r')
                        content = f.read()
                        f.close()
                        self.cycle += 1
                        self.comSub(text_list, type_list)
                        self.cycle += 1
                        tmp = self.runApp(text_list, type_list, [content[:-1]])
                        self.cycle += 1
                        continue
                    except FileNotFoundError:
                        print(f"{text_list[self.cycle+2][0]}: no such file \n")
                        return
                    except IsADirectoryError:
                        print(
                            f"{text_list[self.cycle+2][0]} is a directory \n")
                        return
            if (self.cycle+1 < len(text_list)) and text_list[self.cycle+1] == '<':
                if self.cycle+2 > len(text_list):
                    print("Expected arguement after redirection \n")
                    return
                else:
                    try:
                        f = open(text_list[self.cycle+2][0], 'r')
                        content = f.read()
                        f.close()
                        self.comSub(text_list, type_list)
                        tmp = self.runApp(text_list, type_list, [content[:-1]])
                        self.cycle += 3
                        continue
                    except FileNotFoundError:
                        print(f"{text_list[self.cycle+2][0]}: no such file \n")
                        return
                    except IsADirectoryError:
                        print(
                            f"{text_list[self.cycle+2][0]} is a directory \n")
                        return
            elif text_list[self.cycle] == ';':
                if hidden:
                    self.cycle += 1
                    tmp = [tmp[0] + ' ' + self.runApp(text_list, type_list)[0]]
                else:
                    self.returnOutput(tmp)
                self.cycle += 1
                continue
            elif text_list[self.cycle] == '|':
                if self.cycle+1 > len(text_list):
                    print("Expected arguement after pipe")
                else:
                    self.cycle += 1
                    self.comSub(text_list, type_list)
                    tmp = self.runApp(text_list, type_list, tmp)
            elif text_list[self.cycle] == '>':
                if self.cycle+1 > len(text_list):
                    print("Expected arguement after redirection \n")
                    return
                elif len(text_list) < 2:
                    print("Expected arguement after redirection \n")
                    return
                else:
                    self.cycle += 1
                    try:
                        if os.path.isdir(text_list[self.cycle][0]):
                            print(f"{text_list[self.cycle][0]} is a directory")
                            return
                        content = '\n'.join(tmp)
                        content = content + "\n"
                        f = open(text_list[self.cycle][0], 'w')
                        f.write(content)
                        f.close()
                        self.cycle += 1
                        tmp = None
                        continue
                    except FileNotFoundError:
                        print(f"{text_list[self.cycle][0]}: no such file")
                        return
                    except IsADirectoryError:
                        print(
                            f"{text_list[self.cycle+2][0]} is a directory \n")
                        return
            else:
                self.comSub(text_list, type_list)
                tmp = self.runApp(text_list, type_list)

            self.cycle += 1
        if hidden:
            return tmp
        else:
            self.returnOutput(tmp)
        print()


if __name__ == "__main__":
    arg_num = len(sys.argv) - 1
    if arg_num > 0:
        if arg_num != 2:
            print("wrong number of arguments")
        if sys.argv[1] != '-c':
            print('fuck ur mom')
        evaluator = operator(sys.argv[2])
        evaluator.run()
    else:
        while 1:
            inp = input("> ")
            evaluator = operator(inp)
            evaluator.run()
