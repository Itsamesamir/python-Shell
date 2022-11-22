from abstractFactory import abstract_application, os

<<<<<<< HEAD
=======
class cd(abstract_application):
    def execute(args, input, output):
        if len(args) == 0 or len(args) > 1:
                raise ValueError("wrong number of command line arguments")
        return os.chdir(args[0])
>>>>>>> c82b90e89f7416ee4454427216b58f3c1a8b8331

class cd(abstract_application):
    def execute(args):
        pass
