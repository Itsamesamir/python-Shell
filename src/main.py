import os
import sys
from antlr4 import *
from dist.ShellGrammarLexer import ShellGrammarLexer
from dist.ShellGrammarParser import ShellGrammarParser
from dist.ShellGrammarVisitor import ShellGrammarVisitor
from antlr4.tree.Trees import Trees


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
        return os.getcwd()

    def visitExit(self, ctx):
        sys.exit(0)

    def visitCd(self, ctx):
        textList = getText(stream)
        if len(textList) > 2:
            raise ValueError("Wrong number of arguments")
        try:
            os.chdir(textList[1])
        except FileNotFoundError:
            print("File not found")

    def visitEcho(self, ctx):
        return super().visitEcho(ctx)

    def visitLs(self, ctx):
        textList = getText(stream)
        if len(textList) == 2:
            ls_dir = os.chdir(textList[1])
        elif len(textList) > 2:
            raise ValueError("wrong number of command line arguments")
        else:
            ls_dir = os.getcwd()
        for f in os.listdir(ls_dir):
            print(f, end=" ")

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
        parser = ShellGrammarParser(stream)
        tree = parser.start()
        # evaluator
        visitor = MyVisitor()
        output = visitor.visit(tree)

        print(f"\n {Trees.toStringTree(tree, None, parser)}")

        # stream.fill()
        # print("{:<30} {:<10} {:<10} {:<10}".format(
        #     'Text', 'Type', 'Index', 'Column'))
        # for token in stream.tokens[:-1]:
        #     print("{:<30} {:<10} {:<10} {:<10}".format(
        #         token.text, token.type, token.tokenIndex, token.column))
