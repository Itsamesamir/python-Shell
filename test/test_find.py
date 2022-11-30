from shell import operator
import unittest
import subprocess
import sys
from io import StringIO
import os


class test_Echo(unittest.TestCase):
    def eval(self, inp):
        stdout = sys.stdout
        s = StringIO()
        sys.stdout = s
        evaluator = operator(inp)
        evaluator.run()
        sys.stdout = stdout
        result = s.getvalue()[:-2]
        return result

    def setUp(self):
        filesystem_setup = ";".join(
            [
                "mkdir testEnv",
                "echo \"''\" > testEnv/test.txt",
                "mkdir testEnv/dir1",
                "mkdir -p testEnv/dir2/subdir",
                "echo AAA > testEnv/dir1/file1.txt",
                "echo BBB >> testEnv/dir1/file1.txt",
                "echo AAA >> testEnv/dir1/file1.txt",
                "echo CCC > testEnv/dir1/file2.txt",
                "for i in {1..20}; do echo $i >> testEnv/dir1/longfile.txt; done",
                "echo AAA > testEnv/dir2/subdir/file.txt",
                "echo aaa >> testEnv/dir2/subdir/file.txt",
                "echo AAA >> testEnv/dir2/subdir/file.txt",
                "echo ' ' >> testEnv/dir2/subdir/file.txt",
                "echo DDD >> testEnv/dir2/subdir/file.txt",
                "mkdir testEnv/dir1/subdir",
                "touch testEnv/dir1/subdir/.hidden"
            ]
        )
        subprocess.run([filesystem_setup], shell=True)

    def tearDown(self):
        command = "rm -r testEnv"
        if os.path.exists('testEnv'):
            subprocess.run([command], shell=True)

    def test_find_double_glob(self):
        result = self.eval("find testEnv/* -name *.txt")
        result = set(result.split('\n'))
        self.assertEqual(result, {'testEnv/dir2/subdir/file.txt', 'testEnv/dir1/file2.txt',
                                  'testEnv/dir1/file1.txt', 'testEnv/dir1/longfile.txt'})

    def test_find_path_only(self):
        result = self.eval("find testEnv/")
        result = set(result.split('\n'))
        self.assertEqual(result, {'testEnv/test.txt', 'testEnv/dir2/subdir/file.txt', 'testEnv/dir1/file2.txt',
                         'testEnv/dir1/file1.txt', 'testEnv/dir1/longfile.txt', 'testEnv/dir1/subdir/.hidden'})

    def test_find_pattern_only(self):
        result = self.eval("cd testEnv/ ; find -name *.txt")
        result = set(result.split('\n'))
        self.assertEqual(
            result, {'./test.txt', './dir1/file1.txt', './dir1/file2.txt', './dir2/subdir/file.txt', './dir1/longfile.txt'})

    def test_find_no_matches(self):
        result = self.eval("find testEnv/ -name file")
        self.assertEqual(result, 'find: no matches found: file')

    def test_find_path_error(self):
        with self.assertRaises(ValueError) as context:
            self.eval("find")
        self.assertEqual("find: please enter a file path or pattern \n",
                         str(context.exception))

    def test_find_name_input(self):
        with self.assertRaises(ValueError) as context:
            self.eval("find testEnv/dir1/file1.txt -name")
        self.assertEqual("find: -name requires additional arguments \n",
                         str(context.exception))

    def test_find_operator(self):
        with self.assertRaises(ValueError) as context:
            self.eval("find x -name y testEnv/dir2/subdir/file.txt")
        self.assertEqual("find: testEnv/dir2/subdir/file.txt: unknown primary or operator \n",
                         str(context.exception))

    def test_find_argument_over(self):
        with self.assertRaises(ValueError) as context:
            self.eval("find x y -name")
        self.assertEqual("find: too many arguments \n",
                         str(context.exception))

    def test_find_illegal_arg(self):
        with self.assertRaises(ValueError) as context:
            self.eval("find -name")
        self.assertEqual("find: illegal option --n",
                         str(context.exception))

    def test_find_no_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("find dir5 -name '*.txt'")
        self.assertEqual(
            "find: dir5: no such file or directory \n", str(context.exception))


if __name__ == "__main__":
    unittest.main()
