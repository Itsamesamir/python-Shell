from os import listdir
import os
from abstractFactory import abstract_application

class ls(abstract_application):
    def execute(args, input, output):
        if len(args) == 0:
                ls_dir = os.getcwd()
        elif len(args) > 1:
            raise ValueError("wrong number of command line arguments")
        else:
            ls_dir = args[0]
        for f in listdir(ls_dir):
            if not f.startswith("."):
                return (f + "\n")