from abstractFactory import abstract_application, os

class cat(abstract_application):
    def execute(args):
        if len(args) > 1:
            arr = []
            with open(args) as f:
                while True:
                    line = f.readline()
                    if not line:
                        break
                    # array of strings in text
                    arr.append(line.strip())
        else:
            raise ValueError("wrong number of command line arguments")