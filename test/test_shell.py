from shell import operator
from unittest.mock import patch
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
        command = "rm -r testEnv"
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

    def cat_glob(self):
        result = self.eval("cd testEnv/dir1/file1.txt | cat")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "BBB", "AAA"])

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

    def test_head_empty(self):
        result = self.eval("head testEnv/dir1/file1.txt")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', 'BBB', 'AAA'])

    def test_head_index_error(self):
        with self.assertRaises(IndexError) as context:
            self.eval("head -n")
        self.assertEqual("head: option requires an argument -- n \n",
                         str(context.exception))

    def test_head_lines_pipe(self):
        result = self.eval("cat testEnv/dir1/file1.txt | head -n 2")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', 'BBB'])

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

    def test_cd_fake_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("cd testEnv/dir3")
        self.assertEqual(
            "cd: no such file or directory testEnv/dir3 \n", str(context.exception))

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
            self.eval("cut -b a testEnv/dir1/file1.txt")
        self.assertEqual("cut: illegal line count \n",
                         str(context.exception))

        # Tests for ls

    def test_ls(self):
        result = self.eval("ls")
        result = result.split('\n')
        list_dir = []
        for f in os.listdir():
            if f[0] == '.':
                continue
            else:
                list_dir.append(f)
        self.assertEqual(set(result), set(list_dir))

    def test_ls_hidden(self):
        result = self.eval("ls testEnv/dir1/subdir")
        result = result.split('\n')
        self.assertEqual(result, [""])

    def test_ls_dir(self):
        result = self.eval("ls testEnv")
        result = result.split('\n')
        self.assertEqual(set(result), {"test.txt", "dir2", "dir1"})

    def test_ls_fake_dir(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("ls testEnv/dir3")
        self.assertEqual(
            "ls: no such file or directory testEnv/dir3 \n", str(context.exception))

    def test_ls_two_paths(self):
        result = self.eval("ls testEnv/dir1 testEnv/dir2")
        result = result.split('\n')
        self.assertEqual(
            set(result), {"\033[1;36;40mdir1:\033[1;37;40m", "longfile.txt", "subdir", "file1.txt", "file2.txt", "", "\033[1;36;40mdir2:\033[1;37;40m", "subdir"})

    def test_ls_two_path_one_fake(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("ls testEnv/dir1 testEnv/dir3")
        self.assertEqual(
            "ls: no such file or directory testEnv/dir3 \n", str(context.exception))

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

    def test_redirection_infront(self):
        result = self.eval("< testEnv/dir1/file2.txt cat")
        result = result.split('\n')
        self.assertEqual(result, ['CCC'])

    def test_redirection_right(self):
        self.eval("echo 'hello world' > testEnv/test.txt")
        f = open('testEnv/test.txt', 'r')
        result = ' '.join(f.read().splitlines())
        f.close()
        self.assertEqual(result, 'hello world')

    def test_command_substitution_sequence(self):
        result = self.eval("echo `echo boo; echo hoo`")
        self.assertEqual(result, "boo hoo")

    def test_uniq(self):
        result = self.eval("uniq testEnv/dir1/file1.txt")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', 'BBB', 'AAA'])

    def test_uniq_insensitive(self):
        result = self.eval("uniq -i testEnv/dir2/subdir/file.txt")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', ' ', 'DDD'])

    def test_uniq_pipe(self):
        result = self.eval("uniq -i < testEnv/dir2/subdir/file.txt")
        result = result.split('\n')
        self.assertEqual(result, ['AAA', ' ', 'DDD'])

    def test_uniq_fake_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("uniq testEnv/dir1/file3.txt")
        self.assertEqual(
            "uniq: testEnv/dir1/file3.txt: no such file or directory \n", str(context.exception))

    # Tests for cat

    def test_cat(self):
        result = self.eval("cat testEnv/dir1/file1.txt testEnv/dir1/file2.txt")
        result = result.split('\n')
        self.assertEqual(result, ["AAA", "BBB", "AAA", "CCC"])

    @patch('builtins.input', side_effect=[""])
    def test_cat_stdin(self):
        result = self.eval("cat")
        self.assertEqual(result, "")

    def test_cat_fake_file(self):
        with self.assertRaises(FileNotFoundError) as context:
            self.eval("cat testEnv/dir1/file3.txt testEnv/dir1/file2.txt")
        self.assertEqual(
            "cat: testEnv/dir1/file3.txt: no such file or directory \n", str(context.exception))

    def test_cat_dir_as_file(self):
        with self.assertRaises(IsADirectoryError) as context:
            self.eval("cat testEnv/dir1 testEnv/dir2/file.txt")
        self.assertEqual(
            "cat: testEnv/dir1: is a directory \n", str(context.exception))

    def test_pwd_args(self):
        with self.assertRaises(ValueError) as context:
            self.eval("pwd testEnv")
        self.assertEquals("pwd: too many arguments", str(context.exception))


if __name__ == "__main__":
    unittest.main()
