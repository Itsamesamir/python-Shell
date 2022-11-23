import os
import sys
from antlr4 import *
from dist.ShellGrammarLexer import ShellGrammarLexer
from dist.ShellGrammarParser import ShellGrammarParser
from dist.ShellGrammarVisitor import ShellGrammarVisitor
from antlr4.tree.Trees import Trees

APPLICATIONS = ['pwd', 'cd', 'echo', 'ls', 'cat', 'head',
                'tail', 'grep', 'find', 'sort', 'cat', 'uniq', 'exit']


class operator():
    def __init__(self, stream):
        self.textList = [token.text for token in stream.tokens[:-1]]
        self.indexList = [token.tokenIndex for token in stream.tokens[:-1]]
        self.typeList = [token.type for token in stream.tokens[:-1]]
        self.cycle = 0

    # APPLICATIONS
    def pwd(self, args):
        if len(args) > 0:
            print("pwd: too many arguments \n")
            return
        print(os.getcwd())
        return os.getcwd()

    def exit(self, args):
        sys.exit(0)

    def cd(self, args):
        if len(args) > 1:
            print(f"cd: string not in pwd: {args[0]} \n")
            return
        try:
            if len(args) == 0:
                return os.chdir('/')
            else:
                return os.chdir(args[0])
        except FileNotFoundError:
            print(f"cd: no such file or directory {args[0]} \n")

    def echo(self, args):
        unfiltered = ""
        unfiltered = ' '.join(args)
        filterString = ''.join(
            (filter(lambda x: x not in ['\'', '"', '`'], unfiltered)))
        print(filterString + '\n')

    def ls(self, args):
        if len(args) == 1:
            ls_dir = args[0]
        elif len(args) > 1:
            raise ValueError("too many arguements")
        else:
            ls_dir = os.getcwd()
        try:
            for f in os.listdir(ls_dir):
                print(f'{f}', end='    ')
            print('\n')
        except FileNotFoundError:
            print(f"ls: no such file or directory {args[0]} \n")

    def cat(self, args):
        if len(args) == 0:
            try:
                while 1:
                    inp = input()
                    print(inp)
            except KeyboardInterrupt:
                print('\n')
                return
        for file_path in args:
            try:
                f = open(file_path, 'r')
                content = f.read()
                f.close()
                print(content[:-1])
            except FileNotFoundError:
                print(f"cat: {file_path}: no such file or directory")
        print()

    # def head():

    def run(self):
        # Segments tokens into groups seperated by sequences, pipes, or redirections
        sections = []
        tmp_list = []
        for n in range(0, len(self.textList)):
            if self.textList[n] in [';', '|', '<', '>']:
                sections.append(tmp_list.copy())
                tmp_list.clear()
                sections.append(self.textList[n])
            else:
                tmp_list.append(self.textList[n])
        sections.append(tmp_list)

        while len(sections) > self.cycle:
            if sections[self.cycle] not in [';', '|', '<', '>']:
                if sections[self.cycle][0] in APPLICATIONS:
                    tmp = eval(
                        'self.'+sections[self.cycle][0]+'('+str(sections[self.cycle][1:])+')')
                else:
                    tmp = sections[self.cycle]
            self.cycle += 1

# CODE FOR VISITOR


def getIndex(stream):
    tmp = []
    for token in stream.tokens[:-1]:
        tmp.append(token.tokenIndex)

    return tmp


def getType(stream):
    tmp = []
    for token in stream.tokens[:-1]:
        tmp.append(token.type)

    return tmp


def getText(stream):
    tmp = []
    for token in stream.tokens[:-1]:
        tmp.append(token.text)

    return tmp


class MyVisitor(ShellGrammarVisitor):
    def visitPwd(self, ctx):
        print(os.getcwd())

    def visitExit(self, ctx):
        sys.exit(0)

    def visitCd(self, ctx):
        textList = getText(stream)
        if len(textList) > 2:
            raise ValueError("Wrong number of arguments")
        try:
            if len(textList) == 1:

                os.chdir('/')
            else:
                os.chdir(textList[1])
        except FileNotFoundError:
            print("File not found")

    def visitEcho(self, ctx):
        textList = getText(stream)
        unfiltered = ""
        unfiltered = ' '.join(textList[1:])
        filterString = ''.join(
            (filter(lambda x: x not in ['\'', '"', '`'], unfiltered)))
        print(filterString)
        print("\n")

    def visitLs(self, ctx):
        textList = getText(stream)
        if len(textList) == 2:
            ls_dir = os.chdir(textList[1])
        elif len(textList) > 2:
            raise ValueError("wrong number of command line arguments")
        else:
            ls_dir = os.getcwd()
        for f in os.listdir(ls_dir):
            print(f'{f}', end=" ")
        print('\n')

    def visitCat(self, ctx):
        return super().visitCat(ctx)

    def visitHead(self, ctx):
        return super().visitHead(ctx)

    def visitTail(self, ctx):
        return super().visitTail(ctx)

    def visitGrep(self, ctx):
        print(getText(stream))
        print(getIndex(stream))
        return super().visitGrep(ctx)


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

        # stream.fill()
        # print("{:<30} {:<10} {:<10} {:<10}".format(
        #     'Text', 'Type', 'Index', 'Column'))
        # for token in stream.tokens[:-1]:
        #     print("{:<30} {:<10} {:<10} {:<10}".format(
        #         token.text, token.type, token.tokenIndex, token.column))
