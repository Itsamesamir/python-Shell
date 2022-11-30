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

    def test_head_empty(self):
        result = self.eval("head testEnv/dir1/file1.txt")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', 'BBB', 'AAA'])

    def test_head_index_error(self):
        with self.assertRaises(IndexError) as context:
            self.eval("head -n")
        self.assertEqual("head: option requires an argument -- n \n",
                         str(context.exception))

    def test_head_illegal_line(self):
        with self.assertRaises(ValueError) as context:
            self.eval("head -n s")
        self.assertEqual("head: illegal line count \n",
                         str(context.exception))

    def test_head_lines_pipe(self):
        result = self.eval("cat testEnv/dir1/file1.txt | head -n 2")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', 'BBB'])

    def test_head_fake_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("head testEnv/dir1/file3.txt testEnv/dir1/file2.txt")
        self.assertEqual(
            "head: testEnv/dir1/file3.txt: no such file or directory \n", str(context.exception))

    def test_head_multiple_files(self):
        result = self.eval(
            "head testEnv/dir1/file1.txt testEnv/dir1/file2.txt")
        result = result.split('\n')
        self.assertEqual(result, ['==> testEnv/dir1/file1.txt <==', 'AAA',
                         'BBB', 'AAA', '', '==> testEnv/dir1/file2.txt <==', 'CCC'])

    def test_head_dir(self):
        result = self.eval("head testEnv/dir1/file1.txt testEnv/dir2")
        result = result.split('\n')
        self.assertEqual(result, ['==> testEnv/dir1/file1.txt <==', 'AAA', 'BBB', 'AAA',
                         'head: testEnv/dir2: is a directory'])


if __name__ == "__main__":
    unittest.main()
