import unittest

from python.problem_0000_0100.problem_0001_0010 import Solution
from python.problem_0000_0100.problem_0001_0010 import ListNode

solution = Solution()


class Test00000100(unittest.TestCase):
    """Code for testing the solutions."""

    def test0001(self):
        nums = [2, 7, 11, 15]
        target = 9
        result = [0, 1]

        self.assertEqual(solution.twoSum(nums, target), result)

    def test0002(self):
        node1_1 = ListNode(2)
        node1_2 = ListNode(4)
        node1_3 = ListNode(3)

        node2_1 = ListNode(5)
        node2_2 = ListNode(6)
        node2_3 = ListNode(4)

        node1_1.next = node1_2
        node1_2.next = node1_3

        node2_1.next = node2_2
        node2_2.next = node2_3

        result = solution.addTwoNumbers(node1_1, node2_1)

        self.assertEqual(result.val, 7)
        self.assertEqual(result.next.val, 0)
        self.assertEqual(result.next.next.val, 8)
        self.assertIsNone(result.next.next.next)

    def test003(self):
        s1 = "abcabcbb"
        result1 = 3

        s2 = "bbbbb"
        result2 = 1

        s3 = "pwwkew"
        result3 = 3
        self.assertEqual(solution.lengthOfLongestSubstring(s1), result1)
        self.assertEqual(solution.lengthOfLongestSubstring(s2), result2)
        self.assertEqual(solution.lengthOfLongestSubstring(s3), result3)
