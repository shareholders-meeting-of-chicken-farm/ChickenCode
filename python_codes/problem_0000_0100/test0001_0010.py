import unittest

from python_codes.problem_0000_0100.problem_0001_0010 import Solution
from python_codes.problem_0000_0100.problem_0001_0010 import ListNode

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

    def test005(self):
        in1 = "abcb"
        result1 = "bcb"
        self.assertEqual(result1, solution.longestPalindrome(in1))

        in2 = "cbbd"
        result2 = "bb"
        self.assertEqual(result2, solution.longestPalindrome(in2))

        in3 = "ebabababe"
        result3 = in3
        self.assertEqual(result3, solution.longestPalindrome(in3))

        in4 = "ac"
        result4 = ["a", "c"]
        self.assertIn(solution.longestPalindrome(in4), result4)

    def test006(self):
        in1_1 = "PAYPALISHIRING"
        in1_2 = 3
        result1 = "PAHNAPLSIIGYIR"

        in2_2 = 4
        result2 = "PINALSIGYAHRPI"

        self.assertEqual(result1, solution.convert(in1_1, in1_2))
        self.assertEqual(result2, solution.convert(in1_1, in2_2))

    def test007(self):
        in1 = 123
        result1 = 321
        self.assertEqual(result1, solution.reverse(in1))

        in2 = 120
        result2 = 21
        self.assertEqual(result2, solution.reverse(in2))

        in3 = 1534236469
        result3 = 0
        self.assertEqual(result3, solution.reverse(in3))

        in4 = 8463847412
        result4 = 0
        self.assertEqual(result4, solution.reverse(in4))

        in5 = -in4
        result5 = -2147483648
        self.assertEqual(result5, solution.reverse(in5))

    def test008(self):
        in1 = "-21"
        result1 = -21
        self.assertEqual(result1, solution.myAtoi(in1))

        in2 = "4193 with words"
        result2 = 4193
        self.assertEqual(result2, solution.myAtoi(in2))

        in3 = "   -21"
        result3 = -21
        self.assertEqual(result3, solution.myAtoi(in3))

        in4 = "words and 987"
        result4 = 0
        self.assertEqual(result4, solution.myAtoi(in4))

        in5 = "-91283472332"
        result5 = -2147483648
        self.assertEqual(result5, solution.myAtoi(in5))

        in6 = "+-2"
        result6 = 0
        self.assertEqual(result6, solution.myAtoi(in6))

        in7 = "   +0 123"
        result7 = 0
        self.assertEqual(result7, solution.myAtoi(in7))

        in8 = "-2147483649"
        result8 = -2147483648
        self.assertEqual(result8, solution.myAtoi(in8))

        in9 = "0-1"
        result9 = 0
        self.assertEqual(result9, solution.myAtoi(in9))

        in10 = "   -88827 5655 U"
        result10 = -88827
        self.assertEqual(result10, solution.myAtoi(in10))

    def test009(self):
        in1 = 4567654
        self.assertTrue(solution.isPalindrome(in1))

        in2 = 54643243
        self.assertFalse(solution.isPalindrome(in2))

        in3 = 98
        self.assertFalse(solution.isPalindrome(in3))

        in4 = 55
        self.assertTrue(solution.isPalindrome(in4))

        in5 = 1000021
        self.assertFalse(solution.isPalindrome(in5))

    def test010(self):
        s = "aa"
        p = "a*"
        self.assertTrue(solution.isMatch(s, p))

        s = "ab"
        p = ".*"
        self.assertTrue(solution.isMatch(s, p))

        s = "aab"
        p = "c*a*b"
        self.assertTrue(solution.isMatch(s, p))

        s = "mississippi"
        p = "mis*is*p*."
        self.assertFalse(solution.isMatch(s, p))
