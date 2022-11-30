from shell import operator
import unittest
import subprocess
import re
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
        command = "rm -r ./testEnv"
        subprocess.run([command], shell=True)

    def test_echo(self):
        result = (self.eval("echo hello world"))
        print(result)
        self.assertEqual(result, "hello world")

    def test_esc_echo(self):
        result = (self.eval("echo '\"Hello world\"'"))
        self.assertEqual(result, '"Hello world"')

    def test_pipe_echo(self):
        result = (self.eval("echo hello | echo world"))
        self.assertEqual(result, "world")

    def test_cd_pwd(self):
        result = self.eval("cd testEnv/dir1; pwd")
        self.assertEqual(result, os.getcwd())

    def test_cat(self):
        result = self.eval("cat testEnv/dir1/file1.txt testEnv/dir1/file2.txt")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "BBB", "AAA", "CCC"])

    def test_reverse_sort(self):
        result = self.eval("sort -r testEnv/dir1/file1.txt")
        result = result.split('\n')
        self.assertEqual(result, ["BBB", "AAA", "AAA"])

    def test_sort(self):
        result = self.eval("sort testEnv/dir1/file1.txt")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "AAA", "BBB"])

    def test_find_double_glob(self):
        result = self.eval("find testEnv/* -name *.txt")
        result = set(result.split('\n'))
        self.assertEqual(result, {'testEnv/dir2/subdir/file.txt', 'testEnv/dir1/file2.txt',
                                  'testEnv/dir1/file1.txt', 'testEnv/dir1/longfile.txt'})

    def test_cd_echo_glob(self):
        result = self.eval("cd testEnv ; echo *")
        result = set(result.split(' '))
        self.assertEqual(result, {'dir2', 'test.txt', 'dir1'})

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

    def test_sort_fake_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("sort testEnv/dir1/file3.txt")
        self.assertEqual(
            "sort: testEnv/dir1/file3.txt: no such file or directory \n", str(context.exception))

    def grep(self):
        result = self.eval(
            "grep AA testEnv/dir1/file1.txt testEnv/dir1/file2.txt ")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "AAA"])

    def grep_pipe(self):
        result = self.eval("cd estEnv/dir1/file1.txt | grep AA")
        result = set(result.split('\n'))
        self.assertEqual(result, {"AAA", "AAA"})

    def grep_glob(self):
        result = self.eval("grep AA testEnv/dir1*")
        result = set(result.split('\n'))
        self.assertEqual(result, {"AAA", "AAA"})

    # def test_sort_glob(self):
    #     pass

    # def test_cut_into_cut(self):
    #     pass

    def test_cd_fake_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("cd testEnv/dir3")
        self.assertEqual(
            "cd: no such file or directory testEnv/dir3 \n", str(context.exception))

    # Tests for ls
    def test_ls(self):
        result = self.eval("ls testEnv")
        result = result.split('\n')
        self.assertEqual(result, ["dir2", "dir1", "test.txt"])

    def test_ls_fake_dir(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("ls testEnv/dir3")
        self.assertEqual(
            "ls: no such file or directory testEnv/dir3", str(context.exception))

    def test_ls_two_paths(self):
        result = self.eval("ls testEnv/dir1 testEnv/dir2")
        result = result.split('\n')
        self.assertEqual(
            result, ["dir1:", "file1.txt", "file2.txt", " ", "dir2:", "file.txt"])

    def test_ls_two_path_one_fake(self):
        result = self.eval("ls testEnv/dir1 testEnv/dir3")
        result = result.split('\n')
        self.assertEqual(
            result, ["dir1:", "file1.txt", "file2.txt", " ", "dir2:", "file.txt"])
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("ls testEnv/dir1 testEnv/dir3")
        self.assertEqual(
            "ls: no such file or directory testEnv/dir3", str(context.exception))


if __name__ == "__main__":
    unittest.main()
