from abstractFactory import abstract_application, os


class cat(abstract_application):
<<<<<<< HEAD
    if len(args) > 1:
=======
    def execute(args):
        if len(args) > 1:
>>>>>>> c82b90e89f7416ee4454427216b58f3c1a8b8331
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