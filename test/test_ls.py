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


if __name__ == "__main__":
    unittest.main()
