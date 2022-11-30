from shell import operator
import unittest
import subprocess
import sys
from io import StringIO


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
        subprocess.run([command], shell=True)

    def test_tail_empty(self):
        result = self.eval("tail testEnv/dir1/file1.txt")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', 'BBB', 'AAA'])

    def test_tail_lines_pipe(self):
        result = self.eval("cat testEnv/dir1/file1.txt | tail -n 2")
        result = result.split('\n')
        self.assertEqual(result, ['BBB', 'AAA'])

    def test_tail_no_arg(self):
        with self.assertRaises(IndexError) as context:
            self.eval("tail -n")
        self.assertEqual("tail: option requires an argument -- n \n",
                         str(context.exception))

    def test_tail_illegal_line(self):
        with self.assertRaises(ValueError) as context:
            self.eval("tail -n s")
        self.assertEqual("tail: illegal line count \n",
                         str(context.exception))

    def test_tail_fake_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("tail testEnv/dir1/file3.txt testEnv/dir1/file2.txt")
        self.assertEqual(
            "tail: testEnv/dir1/file3.txt: no such file or directory \n", str(context.exception))

    def test_tail_multiple_files(self):
        result = self.eval(
            "tail testEnv/dir1/file1.txt testEnv/dir1/file2.txt")
        result = result.split('\n')
        self.assertEqual(result, ['==> testEnv/dir1/file1.txt <==', 'AAA',
                         'BBB', 'AAA', '', '==> testEnv/dir1/file2.txt <==', 'CCC'])

    def test_tail_dir(self):
        result = self.eval("head testEnv/dir1/file1.txt testEnv/dir2")
        result = result.split('\n')
        self.assertEqual(result, ['==> testEnv/dir1/file1.txt <==', 'AAA', 'BBB', 'AAA',
                         'head: testEnv/dir2: is a directory'])
