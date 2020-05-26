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

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> int:
        """Code for solving leetcode problem 04:
        https://leetcode.com/problems/median-of-two-sorted-arrays"""