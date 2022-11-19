from abstractFactory import abstract_application, os

class cd(abstract_application):
    def exec(args, input, output):
        if len(args) == 0 or len(args) > 1:
                raise ValueError("wrong number of command line arguments")
        return os.chdir(args[0])

        # input would be [dir] with options
        # -P, -L or -e