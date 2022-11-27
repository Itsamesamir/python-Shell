import os
import sys
import re
import glob
from antlr4 import *
from dist.ShellGrammarLexer import ShellGrammarLexer
from dist.ShellGrammarParser import ShellGrammarParser
from dist.ShellGrammarVisitor import ShellGrammarVisitor
from antlr4.tree.Trees import Trees

APPLICATIONS = ['pwd', 'cd', 'echo', 'ls', 'cat', 'head',
                'tail', 'grep', 'find', 'sort', 'cut', 'uniq', 'exit']


class operator():
    def __init__(self, stream):
        self.textList = [token.text for token in stream.tokens[:-1]]
        self.indexList = [token.tokenIndex for token in stream.tokens[:-1]]
        self.typeList = [token.type for token in stream.tokens[:-1]]
        self.cycle = 0

    # APPLICATIONS
    def pwd(self, args, pipeArg):
        if len(args) > 0:
            print("pwd: too many arguments")
            return
        return [os.getcwd()]

    def exit(self, args, pipeArg):
        sys.exit(0)

    def cd(self, args, pipeArg):
        if len(args) > 1:
            print(f"cd: string not in pwd: {args[0]}")
            return
        try:
            if len(args) == 0:
                os.chdir('/')
            else:
                os.chdir(args[0])
        except FileNotFoundError:
            print(f"cd: no such file or directory {args[0]}")
            return

    def echo(self, args, pipeArg):
        args = self.glob(None, None, args, True)
        unfiltered = ""
        unfiltered = ' '.join(args)
        filterString = ''.join(
            (filter(lambda x: x not in ['\'', '"', '`'], unfiltered)))
        return [filterString]

    def ls(self, args, pipeArg):
        if len(args) == 1:
            ls_dir = self.glob(None, None, args, True)
        elif len(args) > 1:
            print(f"ls: string not in pwd: {args[0]}")
            return
        else:
            ls_dir = [os.getcwd()]
        try:
            result = []
            for path in ls_dir:
                if os.path.isdir(path):
                    for f in os.listdir(path):
                        result.append(f+'\t')
                else:
                    result.append(path+'\t')
            return result
        except FileNotFoundError:
            print(f"ls: no such file or directory {args[0]}")
            return

    def cat(self, args, pipeArg):
        if len(args) == 0:
            try:
                while 1:
                    inp = input()
                    print(inp)
            except KeyboardInterrupt:
                print()
                return
        result = []
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

    def head(self, args, pipeArg):
        index = 10
        if len(args) == 0:
            pass
        else:
            if args[0] == '-n':
                try:
                    index = int(args[1])
                    if index < 1:
                        print(f"head: illegal line count -- {index}")
                        return
                    args.pop(0)
                    args.pop(0)
                except IndexError:
                    print(f"head: option requires an arguement -- n")
                    return
                except ValueError:
                    print(f"head: illegal line count -- \'{args[1]}\'")
                    return

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

    def tail(self, args, pipeArg):
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
                    print(f"tail: option requires an arguement -- n")
                    return
                except ValueError:
                    print(f"tail: illegal line count \'{args[1]}\'")
                    return

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
                for line in lines[index:]:
                    result.append(line[:-1])
            except FileNotFoundError:
                result.append(f"head: {file_path}: no such file or directory")
        return result

    def grep(self, args, pipeArg):
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
                        else:
                            result.append(f"{file_path}: {line}")
            except FileNotFoundError:
                result.append(
                    f"grep: {file_path}: no such file or directory")
        return result

    def uniq(self, args, pipeArg):
        case = False
        if len(args) == 0:
            pass
        else:
            if args[0] == '-i':
                case = True
                args.pop(0)

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

        if len(args) > 1:
            print(f"uniq: too many arguments")
            return
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
                            lines.pop(n)
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
                print(f"uniq: {args[0]}: no such file or directory")
                return

    def find(self, args, pipeArg):
        pattern = None
        if len(args) == 0:
            print("find: please enter a file path or pattern")
            return
        if len(args) > 1:
            if args[1] == '-name':
                if len(args) == 2:
                    print("find: -name requires additional arguements")
                    return
                elif len(args) > 3:
                    print(f"find: {args[3]}: unkown primary or operator")
                    return
            elif args[0] == '-name':
                args.insert(0, './')
            else:
                print("find: too many arguements")
                return
        if len(args) == 1:
            if args[0] == '-name':
                print("find: illegal option --n")
            else:
                args.append('-name')
                args.append('*')

        result = []
        pattern = args[2]
        args = self.glob(None, None, args[:-1], True)
        args.append(pattern)
        for filepath in args[:-2]:
            if os.path.exists(filepath):
                for n in self.glob(args[-1], filepath):
                    result.append(n)
                if len(result) == 0:
                    result.append(f"find: no matches found: {args[-1]}")
            else:
                print(f"find: {filepath}: no such file or directory")
                return
        return result

    # EVALUATION

    def formatStream(self):
        text_list = []
        type_list = []
        tmp1 = []
        tmp2 = []
        for n in range(0, len(self.textList)):
            if self.textList[n] in [';', '|', '<', '>']:
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
                else:
                    tmp1.append(self.textList[n])
                tmp2.append(self.typeList[n])
        text_list.append(tmp1)
        type_list.append(tmp2)
        return [text_list, type_list]

    def runApp(self, text_list, notComSub, pipeArg=None):
        if notComSub:
            if text_list[self.cycle][0] in APPLICATIONS:
                tmp = eval(
                    'self.'+text_list[self.cycle][0]+'('+str(text_list[self.cycle][1:])+','+str(pipeArg)+')')
                return tmp
            else:
                print(
                    f"COMP0010 shell: command not found: {text_list[self.cycle][0]}")
                return
        else:
            if text_list[0] in APPLICATIONS:
                tmp = eval(
                    'self.'+text_list[0]+'('+str(text_list[1:])+')')
                return tmp
            else:
                print(
                    f"COMP0010 shell: command not found: {text_list[0]}")
                return

    def comSub(self, text_list, type_list):
        for n in range(0, len(text_list[self.cycle])):
            if type_list[self.cycle][n] == 20:
                tmp_list = text_list[self.cycle][n].split()
                tmp = self.runApp(tmp_list, False)
                text_list[self.cycle][n] = ' '.join(tmp)
            if type_list[self.cycle][n] == 19:
                if text_list[self.cycle][n].count('`') % 2 != 0:
                    try:
                        while 1:
                            inp = input()
                    except KeyboardInterrupt:
                        print('\n')
                        return
                elif text_list[self.cycle][n].count('`') < 2:
                    continue
                else:
                    backq_split = text_list[self.cycle][n].split('`')
                    count = 1
                    while len(backq_split) > count:
                        tmp_list = backq_split[count].split()
                        tmp = self.runApp(tmp_list, False)
                        backq_split[count] = ''.join(tmp)
                        count += 2
                    text_list[self.cycle][n] = '`'.join(backq_split)

    def glob(self, pattern=None, path=None, args=None, basic=False):
        result = []
        if args:
            for n in range(0, len(args)):
                if '*' in args[n]:
                    result = result + self.glob(args[n], None, None, True)
                else:
                    result.append(args[n])
            return result
        if not pattern or '*' not in pattern:
            return result
        for n in range(0, len(self.typeList[self.cycle])):
            if (self.textList[self.cycle][n] == pattern):
                if (self.textList[self.cycle][0] != 'find') and (self.typeList[self.cycle][n] == 19 or self.typeList[self.cycle][n] == 18):
                    result.append(self.textList[self.cycle][n])
                    return result
        pattern = list(pattern)
        for n in range(0, len(pattern)):
            if pattern[n] in ['^', '$', '.', '|', '?', '+', '(', ')', '[', ']', '{', '}']:
                pattern[n] = '\\' + pattern[n]
            if pattern[n] == '*':
                pattern[n] = '.*'
        pattern.append('$')
        pattern = ''.join(pattern)
        if not path:
            path = './'
        if basic:
            for fileName in os.listdir(path):
                if re.search(pattern, fileName):
                    result.append(os.path.join(fileName))
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

    def printOutput(self, output, text_list):
        if len(text_list) > self.cycle+1 and text_list[self.cycle+1] in ['|', '<', '>']:
            return
        if text_list[self.cycle][0] == 'ls':
            if output:
                for arg in output[:-1]:
                    print(arg, end='      ')
                print(output[-1])
        elif output == None:
            return
        else:
            for output in output:
                print(output)
        if len(text_list) > self.cycle+1 and text_list[self.cycle+1] == ';':
            return
        return

    def run(self):
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
            if (self.cycle+1 < len(text_list)) and text_list[self.cycle+1] == '<':
                if self.cycle+2 > len(text_list):
                    print("Expected arguement after redirection")
                else:
                    try:
                        if os.path.isdir(text_list[self.cycle+2][0]):
                            print(
                                f"{text_list[self.cycle+2][0]} is a directory")
                            return
                        f = open(text_list[self.cycle+2][0], 'r')
                        content = f.read()
                        f.close()
                        self.comSub(text_list, type_list)
                        tmp = self.runApp(text_list, True, [content])
                        self.cycle += 3
                        continue
                    except FileNotFoundError:
                        print(f"{text_list[self.cycle+2][0]}: no such file")
                        return
            elif text_list[self.cycle] == ';':
                self.cycle += 1
                continue
            elif text_list[self.cycle] == '|':
                if self.cycle+1 > len(text_list):
                    print("Expected arguement after pipe")
                else:
                    self.cycle += 1
                    self.comSub(text_list, type_list)
                    tmp = self.runApp(text_list, True, tmp)
            elif text_list[self.cycle] == '>':
                if self.cycle+1 > len(text_list):
                    print("Expected arguement after redirection")
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
                        continue
                    except FileNotFoundError:
                        print(f"{text_list[self.cycle][0]}: no such file")
                        return
            else:
                self.comSub(text_list, type_list)
                tmp = self.runApp(text_list, True)

            self.printOutput(tmp, text_list)
            self.cycle += 1
        print()


if __name__ == "__main__":
    while 1:
        data = InputStream(input("> "))
        # lexer
        lexer = ShellGrammarLexer(data)
        stream = CommonTokenStream(lexer)
        stream.fill()
        # parser
        # parser = ShellGrammarParser(stream)
        # tree = parser.start()
        # evaluator
        evaluator = operator(stream)
        evaluator.run()
        # visitor = MyVisitor()
        # visitor.visit(tree)

        # print(f"\n {Trees.toStringTree(tree, None, parser)}")
