import os
from abc import ABC, abstractmethod
from typing import Type

class abstract_application:

    @abstractmethod
    def __init__(self, args, input, output) -> None:
        self.args = args
        self.input = input
        self.output = output

    def execute(args, input, output) -> None:
        raise NotImplementedError
    
    def __str__(self) -> str:
        raise NotImplementedError
    
