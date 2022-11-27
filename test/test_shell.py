import unittest

#from yaja import eval
from shell import operator
from collections import deque


class TestShell(unittest.TestCase):
    def test_shell(self):
        evaluator = operator("echo foo")
        evaluator.run()

# class TestShell(unittest.TestCase):
#     def test_shell(self):
#         out = deque()
#         eval("echo foo", out)
#         self.assertEqual(out.popleft(), "foo\n")
#         self.assertEqual(len(out), 0)


if __name__ == "__main__":
    unittest.main()
