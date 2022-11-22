from abstractFactory import abstract_application, os

class echo(abstract_application):
    def execute(args, input, output):
        return (" ".join(args) + "\n")