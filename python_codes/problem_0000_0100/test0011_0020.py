import unittest

from python_codes.problem_0000_0100.problem_0011_0020 import Solution

solution = Solution()


class Test00000100(unittest.TestCase):
    """Code for testing the solutions."""

    def test11(self):
        input_list = [1, 8, 6, 2, 5, 4, 8, 3, 7]
        result = 49
        self.assertEqual(result, solution.maxArea(input_list))

    def test12(self):
        num = 1994
        result = "MCMXCIV"
        self.assertEqual(result, solution.intToRoman(num))

    def test13(self):
        s = "MCMXCIV"
        result = 1994
        self.assertEqual(result, solution.romanToInt(s))

    def test14(self):
        strs = ["flower", "flow", "flight"]
        result = "fl"
        self.assertEqual(result, solution.longestCommonPrefix(strs))

        strs = ["dog", "dco", "dr"]
        result = "d"
        self.assertEqual(result, solution.longestCommonPrefix(strs))

    def test15(self):
        nums = [-1, 0, 1, 2, -1, -4]
        solution_set1 = [
            [-1, 0, 1],
            [-1, -1, 2]
        ]
        solution_set2 = [
            [-1, -1, 2],
            [-1, 0, 1]
        ]

        self.assertIn(solution.threeSum(nums), [solution_set1, solution_set2])
