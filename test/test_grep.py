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

    def test_grep(self):
        result = self.eval(
            "grep AA testEnv/dir1/file1.txt testEnv/dir1/file2.txt ")
        result = result.split('\n')
        self.assertEqual(
            result, ["testEnv/dir1/file1.txt:AAA", "testEnv/dir1/file1.txt:AAA"])

    def test_grep_pipe(self):
        result = self.eval("cat testEnv/dir1/file1.txt | grep AA")
        result = (result.split('\n'))
        self.assertEqual(
            result, ["AAA", "AAA"])

    def test_grep_glob(self):
        result = self.eval("grep AA testEnv/dir1*")
        result = set(result.split('\n'))
        self.assertEqual(
            result, {"testEnv/dir1/file1.txt:AAA", "testEnv/dir1/file1.txt:AAA", "grep: testEnv/dir1/subdir: is a directory"})

    def test_grep_few_arg(self):
        with self.assertRaises(ValueError) as context:
            self.eval("grep")
        self.assertEquals(
            "grep: too few arguments specified \n", str(context.exception))

    def test_grep_fake_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("grep aaa testEnv/dir1/file3.txt")
        self.assertEquals(
            "grep: testEnv/dir1/file3.txt: no such file or directory \n", str(context.exception))


if __name__ == "__main__":
    unittest.main()
