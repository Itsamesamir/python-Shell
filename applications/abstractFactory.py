from typing import Type

class abstract_application:
    def __init__(self, name:str) -> None:
        self.name = name
    
    def exec(self):
        pass
    