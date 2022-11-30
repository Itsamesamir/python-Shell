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

    def test_cut(self):
        result = self.eval("cut -b 1-,2- testEnv/dir2/subdir/file.txt")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "aaa", "AAA", " ", "DDD"])

    def test_cut_top(self):
        result = self.eval("cut -b -2,-3 testEnv/dir2/subdir/file.txt")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "aaa", "AAA", " ", "DDD"])

    def test_cut_bottom(self):
        result = self.eval("cut -b 2-,1- testEnv/dir2/subdir/file.txt")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "aaa", "AAA", " ", "DDD"])

    def test_cut_arguments(self):
        result = self.eval(
            "cut -b 1-3 testEnv/dir1/file1.txt")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "BBB", "AAA"])

    def test_cut_pipe(self):
        result = self.eval("echo hello|cut -b 1")
        self.assertEqual(result, "h")

    def test_cut_arg(self):
        with self.assertRaises(ValueError) as context:
            self.eval("cut")
        self.assertEqual("cut: no arguments specified \n",
                         str(context.exception))

    def test_cut_no_bytes(self):
        with self.assertRaises(IndexError) as context:
            self.eval("cut -b")
        self.assertEqual("cut: option requires an argument -- b \n",
                         str(context.exception))

    def test_cut_illegal_lines(self):
        with self.assertRaises(ValueError) as context:
            self.eval("cut -b --3-=4,2  testEnv/dir1/file1.txt")
        self.assertEqual("cut: illegal input \n",
                         str(context.exception))

    def test_cut_file_not_found(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval(" cut -b 1 testEnv/dir1/file3.txt")
        self.assertEqual(
            "cut: testEnv/dir1/file3.txt: no such file or directory \n", str(context.exception))


if __name__ == "__main__":
    unittest.main()
