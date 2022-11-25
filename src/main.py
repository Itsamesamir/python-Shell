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
    def pwd(self, args):
        if len(args) > 0:
            print("pwd: too many arguments")
            return
        return [os.getcwd()]

    def exit(self, args):
        sys.exit(0)

    def cd(self, args):
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

    def echo(self, args):
        unfiltered = ""
        unfiltered = ' '.join(args)
        filterString = ''.join(
            (filter(lambda x: x not in ['\'', '"', '`'], unfiltered)))
        return [filterString]

    def ls(self, args):
        if len(args) == 1:
            ls_dir = args[0]
        elif len(args) > 1:
            print("ls: too many arguments")
            return
        else:
            ls_dir = os.getcwd()
        try:
            result = []
            for f in os.listdir(ls_dir):
                result.append(f+'    ')
            return result
        except FileNotFoundError:
            print(f"ls: no such file or directory {args[0]}")
            return

    def cat(self, args):
        if len(args) == 0:
            try:
                while 1:
                    inp = input()
                    print(inp)
            except KeyboardInterrupt:
                print()
                return
        result = []
        for file_path in args:
            try:
                f = open(file_path, 'r')
                content = f.read()
                f.close()
                result.append(content[:-1])
            except FileNotFoundError:
                result.append(
                    f"cat: {file_path}: no such file or directory")
        return result

    def head(self, args):
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

        if len(args) == 0:
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
                f = open(file_path, 'r')
                if fs == None:
                    fs = file_path
                if fs != file_path:
                    result.append('')
                lines = f.readlines()
                if len(args) > 1:
                    result.append(f"==> {file_path} <==")
                for line in lines[:index]:
                    result.append((line[:-1]))
            except FileNotFoundError:
                result.append(f"head: {file_path}: no such file or directory")
        return result

    def tail(self, args):
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

        if len(args) == 0:
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
                f = open(file_path, 'r')
                if fs == None:
                    fs = file_path
                if fs != file_path:
                    result.append(' ')
                lines = f.readlines()
                if len(args) > 1:
                    result.append(f"==> {file_path} <==")
                for line in lines[index:]:
                    result.append(line[:-1])
            except FileNotFoundError:
                result.append(f"head: {file_path}: no such file or directory")
        return result

    def grep(self, args):
        if len(args) == 0:
            print("grep: no arguments were entered")
            return
        elif len(args) == 1:
            try:
                while 1:
                    input()
            except KeyboardInterrupt:
                print()
                return
        else:
            result = []
            pattern = args[0]
            args.pop(0)
            for file_path in args:
                try:
                    f = open(file_path, 'r')
                    lines = f.readlines()
                    for line in lines:
                        match = re.search(pattern, line[:-1])
                        if match:
                            if len(args) == 1:
                                result.append(f"{line[:-1]}")
                            else:
                                result.append(f"{file_path}: {line[:-1]}")
                except FileNotFoundError:
                    result.append(
                        f"grep: {file_path}: no such file or directory")
            return result

    def uniq(self, args):
        if len(args) == 0:
            try:
                while 1:
                    inp = input()
                    print(inp)
            except KeyboardInterrupt:
                print()
                return
        else:
            case = False
            if args[0] == '-i':
                case = True
                args.pop(0)
            if len(args) > 1:
                print(f"uniq: too many arguments")
                return
            else:
                try:
                    f = open(args[0], 'r')
                    lines = f.readlines()
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

                    return [line[:-1] for line in lines]
                except FileNotFoundError:
                    print(f"uniq: {args[0]}: no such file or directory")
                    return

    def find(self, args):
        pattern = None
        if len(args) == 0:
            print("find: please enter a file path")
            return
        elif len(args) > 1:
            if args[1] == '-name':
                if len(args) == 2:
                    print("find: -name requires additional arguements")
                    return
                elif len(args) > 3:
                    print(f"find: {args[3]}: unkown primary or operator")
                    return
                else:
                    pattern = list(args[2]).copy()
                    for n in range(0, len(args[2])):
                        if args[2][n] in ['^', '$', '.', '|', '?', '+', '(', ')', '[', ']', '{', '}']:
                            pattern[n] = '\\' + args[2][n]
                        if args[2][n] == '*':
                            pattern[n] = '.*'
                    pattern.append('$')
                    pattern = ''.join(pattern)
            elif args[0] == '-name':
                print("find: illegal option --n")
                return
            else:
                print("find: too many arguements")
                return

        result = []
        if os.path.exists(args[0]):
            for dName, sdName, fList in os.walk(args[0]):
                if pattern:
                    for fileName in fList:
                        if re.search(pattern, fileName):
                            result.append(os.path.join(dName, fileName))
                else:
                    for fileName in fList:
                        result.append(os.path.join(dName, fileName))
            return result
        else:
            print(f"find: {args[0]}: no such file or directory")
            return

    # EVALUATION

    def runApp(self, text_list, is_cycle):
        if is_cycle:
            if text_list[self.cycle][0] in APPLICATIONS:
                tmp = eval(
                    'self.'+text_list[self.cycle][0]+'('+str(text_list[self.cycle][1:])+')')
                if text_list[self.cycle][0] == 'ls':
                    for output in tmp:
                        print(output, end='      ')
                    print("\n")
                    return
                elif tmp == None:
                    print()
                    return
                else:
                    for output in tmp:
                        print(output)
                print()
                return
            else:
                print(
                    f"COMP0010 shell: command not found: {text_list[self.cycle][0]} \n")
                return
        else:
            if text_list[0] in APPLICATIONS:
                tmp = eval(
                    'self.'+text_list[0]+'('+str(text_list[1:])+')')
                return tmp
            else:
                print(
                    f"COMP0010 shell: command not found: {text_list[0]} \n")
                return

    def run(self):
        # Check if stdrin is empty and if it is end the execution of the function
        if len(self.textList) == 0:
            return
        # print(self.typeList)
        # print(self.textList)
        # Segments tokens into groups seperated by sequences, pipes, or redirections (formats the stream input)
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

        # Processes the actual stream input and applies logic based on class defined functions above
        tmp = None
        while len(text_list) > self.cycle:
            if text_list[self.cycle] not in [';', '|', '<', '>']:
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

                tmp = self.runApp(text_list, True)
            else:
                if text_list[self.cycle] == ';':
                    pass
                if text_list[self.cycle] == '|':
                    pass
            self.cycle += 1


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
