# Generated from idk.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .idkParser import idkParser
else:
    from idkParser import idkParser

# This class defines a complete generic visitor for a parse tree produced by idkParser.

class idkVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by idkParser#command.
    def visitCommand(self, ctx:idkParser.CommandContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#pipe.
    def visitPipe(self, ctx:idkParser.PipeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#call.
    def visitCall(self, ctx:idkParser.CallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#pwd.
    def visitPwd(self, ctx:idkParser.PwdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#cd.
    def visitCd(self, ctx:idkParser.CdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#echo.
    def visitEcho(self, ctx:idkParser.EchoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#ls.
    def visitLs(self, ctx:idkParser.LsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#cat.
    def visitCat(self, ctx:idkParser.CatContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#head.
    def visitHead(self, ctx:idkParser.HeadContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#tail.
    def visitTail(self, ctx:idkParser.TailContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#grep.
    def visitGrep(self, ctx:idkParser.GrepContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#atom.
    def visitAtom(self, ctx:idkParser.AtomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#argument.
    def visitArgument(self, ctx:idkParser.ArgumentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#redirection.
    def visitRedirection(self, ctx:idkParser.RedirectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#non_keyword.
    def visitNon_keyword(self, ctx:idkParser.Non_keywordContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by idkParser#unquoted.
    def visitUnquoted(self, ctx:idkParser.UnquotedContext):
        return self.visitChildren(ctx)



del idkParser