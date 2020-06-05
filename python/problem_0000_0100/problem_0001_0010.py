# coding=utf-8
"""Code for solving Leetcode problem 01-10."""

from typing import List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """Code for solving leetcode problem 01: https://leetcode.com/problems/two-sum/"""
        # 使用一个dict记录已经出现过的数字，并判断target-num[i]是否在dict中出现过。
        num_to_id = {}

        for i in range(len(nums)):
            number_to_find = target - nums[i]
            if number_to_find in num_to_id:
                index = num_to_id[number_to_find]
                return [index, i]

            else:
                num_to_id[nums[i]] = i

        return []

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        """Code for solving leetcode problem 02: https://leetcode.com/problems/add-two-numbers/"""
        # 使用链表模拟竖式计算。
        if not l1:
            return l2

        if not l2:
            return l1

        result = ListNode(0)
        current_node = result

        p1 = l1
        p2 = l2

        carry_flag = 0

        while p1 is not None or p2 is not None:
            p1_val = 0 if p1 is None else p1.val
            p2_val = 0 if p2 is None else p2.val

            add_result = p1_val + p2_val + carry_flag
            carry_flag = 1 if add_result >= 10 else 0

            value = add_result % 10
            current_node.next = ListNode(value)
            current_node = current_node.next

            p1 = p1.next if p1 is not None else None
            p2 = p2.next if p2 is not None else None

        if carry_flag > 0:
            current_node.next = ListNode(1)

        return result.next

    def lengthOfLongestSubstring(self, s: str) -> int:
        """Code for solving leetcode problem 03:
        https://leetcode.com/problems/longest-substring-without-repeating-characters/"""
        # 使用双指针滑动窗口，如果当前窗口没有重复的就推进右侧指针，如果有重复的就推进左侧指针，直到没有重复为止。
        if not s:
            return 0

        current_window_words = set()
        max_length = 1

        p1 = 0
        p2 = 0

        while p2 < len(s):
            while s[p2] in current_window_words:
                current_window_words.remove(s[p1])
                p1 += 1
            current_window_words.add(s[p2])
            if len(current_window_words) > max_length:
                max_length = len(current_window_words)

            p2 += 1

        return max_length

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """Code for solving leetcode problem 04:
        https://leetcode.com/problems/median-of-two-sorted-arrays"""
        # 借助寻找第k小的数的函数。
        # 寻找第k小的数的时候，每次比较两个数组第[k / 2]个数，小的一方以及它前面的
        # 所有数都可以被排除。
        if not nums1:
            length = len(nums2)
            if length % 2 == 1:
                return nums2[length // 2]
            else:
                return (nums2[length // 2] + nums2[length // 2 - 1]) / 2.0
        elif not nums2:
            length = len(nums1)
            if length % 2 == 1:
                return nums1[length // 2]
            else:
                return (nums1[length // 2] + nums1[length // 2 - 1]) / 2.0

        total_num = len(nums1) + len(nums2)

        def find_k_min(k, arr1, arr2, start1, start2):
            # Find the k-th minimum number from arr1[start1:] and
            # arr2[start2:]
            if start1 >= len(arr1):
                return arr2[start2 + k - 1]
            elif start2 >= len(arr2):
                return arr1[start1 + k - 1]
            if k == 1:
                return min(arr1[start1], arr2[start2])
            else:
                len1 = len(arr1) - start1
                len2 = len(arr2) - start2

                # Assert len1 <= len2.
                if len1 > len2:
                    return find_k_min(k, arr2, arr1, start2, start1)

                i = start1 + min(k // 2, len1) - 1
                j = start2 + min(k // 2, len2) - 1

                if arr1[i] >= arr2[j]:
                    return find_k_min(k - (j - start2 + 1), arr1, arr2, start1,
                                      j + 1)

                else:
                    return find_k_min(k - (i - start1 + 1), arr1, arr2, i + 1,
                                      start2)

        if total_num % 2 == 1:
            return find_k_min(total_num // 2 + 1, nums1, nums2, 0, 0)
        else:
            i = find_k_min(total_num // 2 + 1, nums1, nums2, 0, 0)
            j = find_k_min(total_num // 2, nums1, nums2, 0, 0)

            return (i + j) / 2.0

    def longestPalindrome(self, s: str) -> str:
        """Code for solving leetcode problem 05:
        https://leetcode.com/problems/longest-palindromic-substring"""
        # 复杂度为O(n^2)的中心展开算法。依次遍历中心点并左右展开，寻找最长的回文串。
        if len(s) <= 1:
            return s
        s = "$" + "#".join(s) + "&"

        max_center = 0
        max_width = 0
        max_actual_length = 0

        for center in range(1, len(s) - 1):
            width = 1
            while center - width >= 0 and center + width <= len(s) - 1:
                left = center - width
                right = center + width
                if s[left] == s[right]:
                    width += 1
                else:
                    break

            width -= 1

            if s[center] == "#":
                actual_length = 2 * width

            else:
                actual_length = 2 * width - 1
                if actual_length < 1:
                    actual_length = 1

            if actual_length > max_actual_length:
                max_center = center
                max_width = width
                max_actual_length = actual_length

        result = [x for x in
                  s[max_center - max_width: max_center + max_width + 1]
                  if x not in ["#", "&", "$"]]
        return "".join(result)

    def convert(self, s: str, numRows: int) -> str:
        """Code for solving leetcode problem 06:
        https://leetcode.com/problems/zigzag-conversion"""
        if not s or numRows == 1 or numRows == len(s):
            return s

        lines = ["" for _ in range(numRows)]
        current_row = 0
        going_down = True
        for c in s:
            lines[current_row] += c
            if going_down and current_row == numRows - 1:
                going_down = False
                current_row -= 1
            elif not going_down and current_row == 0:
                going_down = True
                current_row += 1

            elif going_down:
                current_row += 1

            else:
                current_row -= 1

        return "".join(lines)

    def reverse(self, x: int) -> int:
        """Code for solving leetcode problem 07:
        https://leetcode.com/problems/reverse-integer"""
        import math
        if x == 0:
            return 0
        negative = x < 0
        x = abs(x)

        result = 0
        m = int(math.log(x, 10))
        n = 0

        while m >= 0:
            current_digit = x // (10 ** m)

            result_threshold = 147483648
            if not negative:
                result_threshold -= 1
            if n > 9 or (n == 9 and current_digit >= 2 and result > result_threshold):
                return 0

            result += (current_digit * (10 ** n))
            x -= current_digit * (10 ** m)
            m -= 1
            n += 1

        if negative:
            result *= -1

        return result

    def myAtoi(self, s: str) -> int:
        """Code for solving leetcode problem 08:
        https://leetcode.com/problems/string-to-integer-atoi"""
        result = 0
        negative = False
        has_met_number = False
        overflow = False
        started = False
        threshold = 214748364
        last_threshold = 7
        leading_flag_count = 0
        for c in s:
            should_stop = False

            if c == " " and started:
                should_stop = True
            elif has_met_number and (ord(c) < ord('0') or ord(c) > ord('9')):
                should_stop = True
            elif (c == "-" or c == "+") and leading_flag_count > 0:
                should_stop = True

            if should_stop:
                if overflow:
                    return 2147483647 if not negative else -2147483648
                return result if not negative else -result

            if c == " ":
                continue

            started = True
            if c == "+":
                leading_flag_count += 1
                continue
            if c == "-":
                negative = True
                last_threshold += 1
                leading_flag_count += 1
                continue
            if result == 0 and c == '0':
                has_met_number = True
                continue
            if ord('0') <= ord(c) <= ord('9'):
                has_met_number = True
                current_digit = ord(c) - ord('0')
                if result > threshold or (result == threshold and current_digit > last_threshold):
                    overflow = True
                    break
                else:
                    result *= 10
                    result += current_digit
            else:
                break

        if overflow:
            return 2147483647 if not negative else -2147483648
        return result if not negative else -result
