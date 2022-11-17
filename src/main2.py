import os
import sys
from antlr4 import *
from dist2.idkLexer import idkLexer
from dist2.idkParser import idkParser
from dist2.idkVisitor import idkVisitor
from antlr4.tree.Trees import Trees


class MyVisitor(idkVisitor):
    def visitPwd(self, ctx):
        return os.getcwd()

    def visitCd(self, ctx: idkParser.CdContext):
        cd_input = self.visit(ctx.right)
        return os.chdir(cd_input)

    def visitEcho(self, ctx: idkParser.EchoContext):
        return super().visitEcho(ctx)

    def visitLs(self, ctx: idkParser.LsContext):
        return super().visitLs(ctx)

    def visitCat(self, ctx: idkParser.CatContext):
        return super().visitCat(ctx)

    def visitHead(self, ctx: idkParser.HeadContext):
        return super().visitHead(ctx)

    def visitTail(self, ctx: idkParser.TailContext):
        return super().visitTail(ctx)

    def visitGrep(self, ctx: idkParser.GrepContext):
        return super().visitGrep(ctx)


if __name__ == "__main__":
    while 1:
        data = InputStream(input(">>> "))
        # lexer
        lexer = idkLexer(data)
        stream = CommonTokenStream(lexer)
        # parser
        parser = idkParser(stream)
        tree = parser.command()
        # evaluator
        visitor = idkVisitor()
        output = visitor.visit(tree)
        print(output)
        # print(Trees.toStringTree(tree, None, parser))
