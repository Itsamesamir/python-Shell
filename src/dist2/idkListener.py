# Generated from idk.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .idkParser import idkParser
else:
    from idkParser import idkParser

# This class defines a complete listener for a parse tree produced by idkParser.
class idkListener(ParseTreeListener):

    # Enter a parse tree produced by idkParser#command.
    def enterCommand(self, ctx:idkParser.CommandContext):
        pass

    # Exit a parse tree produced by idkParser#command.
    def exitCommand(self, ctx:idkParser.CommandContext):
        pass


    # Enter a parse tree produced by idkParser#pipe.
    def enterPipe(self, ctx:idkParser.PipeContext):
        pass

    # Exit a parse tree produced by idkParser#pipe.
    def exitPipe(self, ctx:idkParser.PipeContext):
        pass


    # Enter a parse tree produced by idkParser#call.
    def enterCall(self, ctx:idkParser.CallContext):
        pass

    # Exit a parse tree produced by idkParser#call.
    def exitCall(self, ctx:idkParser.CallContext):
        pass


    # Enter a parse tree produced by idkParser#pwd.
    def enterPwd(self, ctx:idkParser.PwdContext):
        pass

    # Exit a parse tree produced by idkParser#pwd.
    def exitPwd(self, ctx:idkParser.PwdContext):
        pass


    # Enter a parse tree produced by idkParser#cd.
    def enterCd(self, ctx:idkParser.CdContext):
        pass

    # Exit a parse tree produced by idkParser#cd.
    def exitCd(self, ctx:idkParser.CdContext):
        pass


    # Enter a parse tree produced by idkParser#echo.
    def enterEcho(self, ctx:idkParser.EchoContext):
        pass

    # Exit a parse tree produced by idkParser#echo.
    def exitEcho(self, ctx:idkParser.EchoContext):
        pass


    # Enter a parse tree produced by idkParser#ls.
    def enterLs(self, ctx:idkParser.LsContext):
        pass

    # Exit a parse tree produced by idkParser#ls.
    def exitLs(self, ctx:idkParser.LsContext):
        pass


    # Enter a parse tree produced by idkParser#cat.
    def enterCat(self, ctx:idkParser.CatContext):
        pass

    # Exit a parse tree produced by idkParser#cat.
    def exitCat(self, ctx:idkParser.CatContext):
        pass


    # Enter a parse tree produced by idkParser#head.
    def enterHead(self, ctx:idkParser.HeadContext):
        pass

    # Exit a parse tree produced by idkParser#head.
    def exitHead(self, ctx:idkParser.HeadContext):
        pass


    # Enter a parse tree produced by idkParser#tail.
    def enterTail(self, ctx:idkParser.TailContext):
        pass

    # Exit a parse tree produced by idkParser#tail.
    def exitTail(self, ctx:idkParser.TailContext):
        pass


    # Enter a parse tree produced by idkParser#grep.
    def enterGrep(self, ctx:idkParser.GrepContext):
        pass

    # Exit a parse tree produced by idkParser#grep.
    def exitGrep(self, ctx:idkParser.GrepContext):
        pass


    # Enter a parse tree produced by idkParser#atom.
    def enterAtom(self, ctx:idkParser.AtomContext):
        pass

    # Exit a parse tree produced by idkParser#atom.
    def exitAtom(self, ctx:idkParser.AtomContext):
        pass


    # Enter a parse tree produced by idkParser#argument.
    def enterArgument(self, ctx:idkParser.ArgumentContext):
        pass

    # Exit a parse tree produced by idkParser#argument.
    def exitArgument(self, ctx:idkParser.ArgumentContext):
        pass


    # Enter a parse tree produced by idkParser#redirection.
    def enterRedirection(self, ctx:idkParser.RedirectionContext):
        pass

    # Exit a parse tree produced by idkParser#redirection.
    def exitRedirection(self, ctx:idkParser.RedirectionContext):
        pass


    # Enter a parse tree produced by idkParser#non_keyword.
    def enterNon_keyword(self, ctx:idkParser.Non_keywordContext):
        pass

    # Exit a parse tree produced by idkParser#non_keyword.
    def exitNon_keyword(self, ctx:idkParser.Non_keywordContext):
        pass


    # Enter a parse tree produced by idkParser#unquoted.
    def enterUnquoted(self, ctx:idkParser.UnquotedContext):
        pass

    # Exit a parse tree produced by idkParser#unquoted.
    def exitUnquoted(self, ctx:idkParser.UnquotedContext):
        pass



del idkParser