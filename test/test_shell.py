import unittest

from shell import operator
from collections import deque


class TestShell(unittest.TestCase):
    def test_shell(self):
        evaluator = operator("echo foo")
        evaluator.run()


if __name__ == "__main__":
    unittest.main()
