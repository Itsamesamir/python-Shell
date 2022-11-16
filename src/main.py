import sys
import os
from antlr4 import *
from dist.MyGrammarLexer import MyGrammarLexer
from dist.MyGrammarParser import MyGrammarParser
from dist.MyGrammarVisitor import MyGrammarVisitor


def get_username():
    from pwd import getpwuid
    from os import getuid

    return getpwuid(getuid())[0]


class MyVisitor(MyGrammarVisitor):
    # def visitNumberExpr(self, ctx):
    #     value = ctx.getText()
    #     return int(value)

    # def visitParenExpr(self, ctx):
    #     return self.visit(ctx.expr())

    # def visitInfixExpr(self, ctx):
    #     l = self.visit(ctx.left)
    #     r = self.visit(ctx.right)

    #     op = ctx.op.text
    #     operation = {
    #         "+": lambda: l + r,
    #         "-": lambda: l - r,
    #         "*": lambda: l * r,
    #         "/": lambda: l / r,
    #     }
    #     return operation.get(op, lambda: None)()

    def visitPwd(self, ctx):
        return os.getcwd()

    def visitCd(self, ctx: MyGrammarParser.CdContext):
        cd_input = self.visit(ctx.right)
        return os.chdir(cd_input)

    def visitEcho(self, ctx: MyGrammarParser.EchoContext):
        return super().visitEcho(ctx)

    def visitLs(self, ctx: MyGrammarParser.LsContext):
        return super().visitLs(ctx)

    def visitCat(self, ctx: MyGrammarParser.CatContext):
        return super().visitCat(ctx)

    def visitHead(self, ctx: MyGrammarParser.HeadContext):
        return super().visitHead(ctx)

    def visitTail(self, ctx: MyGrammarParser.TailContext):
        return super().visitTail(ctx)

    def visitGrep(self, ctx: MyGrammarParser.GrepContext):
        return super().visitGrep(ctx)


if __name__ == "__main__":
    while 1:
        data = InputStream(input(">>> "))
        # lexer
        lexer = MyGrammarLexer(data)
        stream = CommonTokenStream(lexer)
        # parser
        parser = MyGrammarParser(stream)
        tree = parser.commandline()
        # evaluator
        visitor = MyVisitor()
        output = visitor.visit(tree)
        print(output)
