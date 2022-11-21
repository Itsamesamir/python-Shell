import os
import sys
from antlr4 import *
from dist.ShellGrammarLexer import ShellGrammarLexer
from dist.ShellGrammarParser import ShellGrammarParser
from dist.ShellGrammarVisitor import ShellGrammarVisitor
from antlr4.tree.Trees import Trees


class MyVisitor(ShellGrammarVisitor):
    def visitPwd(self, ctx):
        return os.getcwd()

    def visitCd(self, ctx: ShellGrammarParser.CdContext):
        return super().visitCd(ctx)

    def visitEcho(self, ctx: ShellGrammarParser.EchoContext):
        return super().visitEcho(ctx)

    def visitLs(self, ctx: ShellGrammarParser.LsContext):
        return super().visitLs(ctx)

    def visitCat(self, ctx: ShellGrammarParser.CatContext):
        return super().visitCat(ctx)

    def visitHead(self, ctx: ShellGrammarParser.HeadContext):
        return super().visitHead(ctx)

    def visitTail(self, ctx: ShellGrammarParser.TailContext):
        return super().visitTail(ctx)

    def visitGrep(self, ctx: ShellGrammarParser.GrepContext):
        return super().visitGrep(ctx)


if __name__ == "__main__":
    while 1:
        data = InputStream(input(">>> "))
        # lexer
        lexer = ShellGrammarLexer(data)
        stream = CommonTokenStream(lexer)
        # parser
        parser = ShellGrammarParser(stream)
        tree = parser.start()
        # evaluator
        visitor = ShellGrammarVisitor()
        output = visitor.visit(tree)
        print(output)
        print(Trees.toStringTree(tree, None, parser))
