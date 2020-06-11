import unittest

from python_codes.problem_0000_0100.problem_0011_0020 import Solution

solution = Solution()


class Test00000100(unittest.TestCase):
    """Code for testing the solutions."""

    def test11(self):
        input_list = [1, 8, 6, 2, 5, 4, 8, 3, 7]
        result = 49
        self.assertEqual(result, solution.maxArea(input_list))