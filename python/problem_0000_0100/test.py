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

    def test004(self):
        arr1_1 = [1, 3, 7, 8]
        arr1_2 = [3, 4, 9]
        result1 = 4

        self.assertEqual(solution.findMedianSortedArrays(arr1_1, arr1_2),
                         result1)

        arr2_1 = []
        arr2_2 = [1, 4, 5, 6]
        result2 = 4.5
        self.assertAlmostEqual(solution.findMedianSortedArrays(arr2_1, arr2_2),
                               result2)

        arr3_1 = [1, 3, 9, 11]
        arr3_2 = [8, 9, 10, 12]
        result3 = 9.0
        self.assertAlmostEqual(solution.findMedianSortedArrays(arr3_1, arr3_2),
                               result3)

        arr4_1 = [1, 3]
        arr4_2 = [2]
        result4 = 2
        self.assertAlmostEqual(solution.findMedianSortedArrays(arr4_1, arr4_2),
                               result4)

        arr4_1 = [1, 2]
        arr4_2 = [3, 4]
        result5 = 2.5
        self.assertAlmostEqual(solution.findMedianSortedArrays(arr4_1, arr4_2),
                               result5)