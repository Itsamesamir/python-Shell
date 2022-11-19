from abstractFactory import abstract_application, os

class pwd(abstract_application):
    def exec(args, input, output):

        print(os.getcwd())


        