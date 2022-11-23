import os
import sys
from antlr4 import *
from dist.ShellGrammarLexer import ShellGrammarLexer
from dist.ShellGrammarParser import ShellGrammarParser
from dist.ShellGrammarVisitor import ShellGrammarVisitor
from antlr4.tree.Trees import Trees

APPLICATIONS = ['pwd', 'cd', 'echo', 'ls', 'cat', 'head',
                'tail', 'grep', 'find', 'sort', 'cat', 'uniq', 'exit']


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


class operator():
    def __init__(self, stream):
        self.textList = [token.text for token in stream.tokens[:-1]]
        self.indexList = [token.tokenIndex for token in stream.tokens[:-1]]
        self.typeList = [token.type for token in stream.tokens[:-1]]
        self.cycle = 0

    # APPLICATIONS
    def pwd(self):
        print(os.getcwd())

    def exit(self):
        sys.exit(0)

    def cd(self):
        if len(self.textList) > 2:
            raise ValueError("Wrong number of arguments")
        try:
            if len(self.textList) == 1:

                os.chdir('/')
            else:
                os.chdir(self.textList[1])
        except FileNotFoundError:
            print("File not found")

    def echo(self):
        unfiltered = ""
        unfiltered = ' '.join(self.textList[1:])
        filterString = ''.join(
            (filter(lambda x: x not in ['\'', '"', '`'], unfiltered)))
        print(filterString + '\n')

    def ls(self):
        if len(self.textList) == 2:
            ls_dir = os.chdir(self.textList[1])
        elif len(self.textList) > 2:
            raise ValueError("wrong number of command line arguments")
        else:
            ls_dir = os.getcwd()
        for f in os.listdir(ls_dir):
            print(f'{f}', end=" ")
        print('\n')

    def run(self):
        while len(self.textList) > self.cycle:
            if self.textList[self.cycle] in APPLICATIONS:
                eval('self.'+self.textList[self.cycle]+'()')
            self.cycle += 1


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
        data = InputStream(input("8==D "))
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
