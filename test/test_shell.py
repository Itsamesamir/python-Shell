from shell import operator
import unittest
import subprocess
import sys
from io import StringIO
import os


class TestShell(unittest.TestCase):
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

    def test_none(self):
        result = self.eval("")
        self.assertEqual(result, "")

    def test_unkown_command(self):
        result = self.eval("hello")
        self.assertEqual(result, "COMP0010 shell: command not found: hello")

    def test_back_quotes(self):
        result = self.eval("echo hello `echo world`")
        self.assertEqual(result, 'hello world')

    def test_nested_back_quotes(self):
        result = self.eval('echo "hello `echo world`"')
        self.assertEqual(result, 'hello world')

    def test_left_redirection(self):
        result = self.eval("cat < testEnv/dir1/file1.txt")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', 'BBB', 'AAA'])

    def test_left_redirection_infront(self):
        result = self.eval("< testEnv/dir1/file2.txt cat")
        result = result.split('\n')
        self.assertEqual(result, ['CCC'])

    def test_right_redirection(self):
        self.eval("echo 'hello world' > testEnv/test.txt")
        f = open('testEnv/test.txt', 'r')
        result = ' '.join(f.read().splitlines())
        f.close()
        self.assertEqual(result, 'hello world')

    def test_left_redirection_fake(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("cat < testEnv/dir1/file3.txt")
        self.assertEqual(
            "testEnv/dir1/file3.txt: no such file \n", str(context.exception))

    def test_left_redirection_dir(self):
        with self.assertRaises(IsADirectoryError) as context:
            self.eval("cat < testEnv/dir1")
        self.assertEqual(
            "testEnv/dir1: is a directory \n", str(context.exception))

    def test_left_redirection_fake_infront(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("< testEnv/dir1/file3.txt cat")
        self.assertEqual(
            "testEnv/dir1/file3.txt: no such file \n", str(context.exception))

    def test_left_redirection_dir_infront(self):
        with self.assertRaises(IsADirectoryError) as context:
            self.eval("< testEnv/dir1 cat")
        self.assertEqual(
            "testEnv/dir1: is a directory \n", str(context.exception))

    def test_right_redirection_dir(self):
        with self.assertRaises(IsADirectoryError) as context:
            self.eval("echo 'hello world' > testEnv/dir1")
        self.assertEqual(
            "testEnv/dir1: is a directory \n", str(context.exception))

    def test_command_substitution_sequence(self):
        result = self.eval("echo `echo boo; echo hoo`")
        self.assertEqual(result, "boo hoo")


if __name__ == "__main__":
    unittest.main()
