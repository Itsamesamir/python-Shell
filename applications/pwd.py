from abstractFactory import abstract_application, os

class pwd(abstract_application):
    def execute(args, input, output):
        return os.getcwd()


        