import os
import sys

from antlr4 import InputStream
from antlr4 import CommonTokenStream

from dist.ShellGrammarLexer import ShellGrammarLexer

from applications.pwd import pwd
from applications.cd import cd
from applications.echo import echo
from applications.ls import ls
from applications.cat import cat
from applications.head import head
from applications.tail import tail
from applications.grep import grep
from applications.find import find
from applications.uniq import uniq
from applications.sort import sort
from applications.cut import cut
from applications.exit import exit


APPLICATIONS = ['pwd', 'cd', 'echo', 'ls', 'cat', 'head',
                'tail', 'grep', 'find', 'sort', 'cut', 'uniq', 'exit']


class operator():
    # Parse input string and tokanise it using lexer grammar
    def __init__(self, inp):
        data = InputStream(inp)
        lexer = ShellGrammarLexer(data)
        stream = CommonTokenStream(lexer)
        stream.fill()
        stream = stream.tokens
        self.textList = [token.text for token in stream[:-1]]
        self.indexList = [token.tokenIndex for token in stream[:-1]]
        self.typeList = [token.type for token in stream[:-1]]
        self.cycle = 0

    # Segments tokens into groups seperated by sequences, pipes, or redirections (formats the stream input)
    def formatStream(self):
        text_list = []
        type_list = []
        tmp1 = []
        tmp2 = []
        app = False
        for n in range(0, len(self.textList)):
            if self.textList[n] in [';', '|', '<', '>']:
                if len(tmp1) != 0:
                    text_list.append(tmp1.copy())
                    type_list.append(tmp2.copy())
                    tmp1.clear()
                    tmp2.clear()
                text_list.append(self.textList[n])
                type_list.append(self.typeList[n])
                app = False
            else:
                if (self.textList[n] == "\'") or (self.textList[n] == "\"") or (self.textList[n] == "`"):
                    try:
                        while 1:
                            input()
                    except KeyboardInterrupt:
                        print('\n')
                        return
                if self.typeList[n] in [18, 19, 20]:
                    tmp1.append(self.textList[n][1:-1])
                    tmp2.append(self.typeList[n])
                elif 0 < self.typeList[n] < 14:
                    if not app:
                        if len(tmp1) != 0:
                            text_list.append(tmp1.copy())
                            type_list.append(tmp2.copy())
                            tmp1.clear()
                            tmp2.clear()
                    tmp1.append(self.textList[n])
                    tmp2.append(self.typeList[n])
                    app = True
                else:
                    tmp1.append(self.textList[n])
                    tmp2.append(self.typeList[n])
        if len(tmp1) != 0:
            text_list.append(tmp1)
            type_list.append(tmp2)
        return [text_list, type_list]

    def runApp(self, text_list, pipeArg=None):
        if text_list[self.cycle][0] in APPLICATIONS:
            tmp = eval(
                text_list[self.cycle][0]+'('+str(text_list[self.cycle][1:])+','+str(pipeArg)+')')
            return tmp
        else:
            print(
                f"COMP0010 shell: command not found: {text_list[self.cycle][0]}")
            return

    # Checks for back quotes or double quotes then recursively executes what is in them and replaces command with its output
    def comSub(self, text_list, type_list):
        for n in range(0, len(text_list[self.cycle])):
            if type_list[self.cycle][n] == 20:
                tmp_opp = operator(text_list[self.cycle][n])
                tmp_result = tmp_opp.run(True)
                text_list[self.cycle][n] = tmp_result[0]
            if type_list[self.cycle][n] == 19:
                if '`' not in text_list[self.cycle][n]:
                    continue
                else:
                    backq_split = text_list[self.cycle][n].split('`')
                    count = 1
                    while len(backq_split) > count:
                        tmp_opp = operator(backq_split[count])
                        tmp_result = tmp_opp.run(True)
                        backq_split[count] = tmp_result[0]
                        count += 2
                    text_list[self.cycle][n] = ''.join(backq_split)

    def returnOutput(self, output):
        if output:
            for args in output:
                print(args)
        else:
            pass

    # Opens file, read its contents, and passes it on to the subsequent command
    def redirectionLeft(self, text_list, type_list, infront=False):
        if infront:
            if len(text_list) < 2:
                raise ValueError("Expected argument after redirection \n")
            else:
                try:
                    f = open(text_list[self.cycle+1][0], 'r')
                    content = f.read()
                    f.close()
                    self.cycle += 2
                    self.comSub(text_list, type_list)
                    tmp = self.runApp(text_list, [content[:-1]])
                    self.cycle += 1
                    return tmp
                except FileNotFoundError:
                    raise FileNotFoundError(
                        f"{text_list[self.cycle+1][0]}: no such file \n")
                except IsADirectoryError:
                    raise IsADirectoryError(
                        f"{text_list[self.cycle+1][0]}: is a directory \n")
        else:
            if self.cycle+2 > len(text_list):
                raise ValueError("Expected argument after redirection \n")
            else:
                try:
                    f = open(text_list[self.cycle+2][0], 'r')
                    content = f.read()
                    f.close()
                    self.comSub(text_list, type_list)
                    tmp = self.runApp(text_list, [content[:-1]])
                    self.cycle += 3
                    return tmp
                except FileNotFoundError:
                    raise FileNotFoundError(
                        f"{text_list[self.cycle+2][0]}: no such file \n")
                except IsADirectoryError:
                    raise IsADirectoryError(
                        f"{text_list[self.cycle+2][0]}: is a directory \n")

    def redirectionRight(self, text_list, tmp):
        if self.cycle+1 > len(text_list):
            raise ValueError("Expected argument after redirection \n")
        elif len(text_list) < 2:
            raise ValueError("Expected argument after redirection \n")
        else:
            self.cycle += 1
            try:
                content = '\n'.join(tmp)
                content = content + "\n"
                f = open(text_list[self.cycle][0], 'w')
                f.write(content)
                f.close()
                self.cycle += 1
                return None
            except IsADirectoryError:
                raise IsADirectoryError(
                    f"{text_list[self.cycle][0]}: is a directory \n")

    # Print out result of current command unless its hidden to simply return the result to the next command
    def sequence(self, text_list, tmp, hidden):
        if hidden:
            self.cycle += 1
            tmp = [tmp[0] + ' ' + self.runApp(text_list)[0]]
            self.cycle += 1
            return tmp
        else:
            self.returnOutput(tmp)
            self.cycle += 1

    # Passes output of previous command onto the current command as input

    def pipe(self, text_list, type_list, tmp):
        if self.cycle+1 > len(text_list):
            raise ValueError("Expected argument after pipe")
        else:
            self.cycle += 1
            self.comSub(text_list, type_list)
            return self.runApp(text_list, tmp)

    def run(self, hidden=False):
        # Check if stdrin is empty and if it is end the execution of the function
        if len(self.textList) == 0:
            return

        output = self.formatStream()
        if output:
            text_list = output[0]
            type_list = output[1]
        else:
            return

        # Processes the actual stream input and applies logic based on class defined functions above
        tmp = None
        while len(text_list) > self.cycle:
            if text_list[0] == '<':
                tmp = self.redirectionLeft(text_list, type_list, True)
                continue
            elif (self.cycle+1 < len(text_list)) and text_list[self.cycle+1] == '<':
                tmp = self.redirectionLeft(text_list, type_list)
                continue
            elif text_list[self.cycle] == ';':
                seq_tmp = self.sequence(text_list, tmp, hidden)
                if seq_tmp:
                    tmp = seq_tmp
                continue
            elif text_list[self.cycle] == '|':
                tmp = self.pipe(text_list, type_list, tmp)
            elif text_list[self.cycle] == '>':
                tmp = self.redirectionRight(text_list, tmp)
                continue
            else:
                self.comSub(text_list, type_list)
                tmp = self.runApp(text_list)

            self.cycle += 1

        if hidden:
            return tmp
        else:
            self.returnOutput(tmp)
        print()


if __name__ == "__main__":
    arg_num = len(sys.argv) - 1
    if arg_num > 0:
        if arg_num != 2:
            print("wrong number of arguments")
        if sys.argv[1] != '-c':
            print(f'unexpected command line argument {sys.argv[1]}')
        evaluator = operator(sys.argv[2])
        evaluator.run()
    else:
        while 1:
            inp = input(
                f"\033[1;32;40m{os.getcwd().split('/')[-1]} \033[1;37;40m> ")
            evaluator = operator(inp)
            evaluator.run()
