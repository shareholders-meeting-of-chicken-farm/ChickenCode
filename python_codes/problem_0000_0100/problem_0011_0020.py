# coding=utf-8
"""Code for solving Leetcode problem 11-20."""

from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        """Code for solving leetcode problem 11:
        https://leetcode.com/problems/container-with-most-water/"""
        left = 0
        right = len(height) - 1
        max_area = (right - left) * min(height[left], height[right])

        while left < right:
            if height[left] < height[right]:
                left += 1
                if height[left] <= height[left - 1]:
                    continue
            else:
                right -= 1
                if height[right] <= height[right + 1]:
                    continue

            area = (right - left) * min(height[left], height[right])
            if area > max_area:
                max_area = area

        return max_area

    def intToRoman(self, num: int) -> str:
        """Code for solving leetcode problem 12:
        https://leetcode.com/problems/integer-to-roman/"""
        result = ""
        roman_valid_symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        corresponding_number = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        current_index = 0

        while num > 0:
            if num >= corresponding_number[current_index]:
                result += roman_valid_symbols[current_index]
                num -= corresponding_number[current_index]
            else:
                current_index += 1

        return result

    def romanToInt(self, s: str) -> int:
        """Code for solving leetcode problem 13:
        https://leetcode.com/problems/roman-to-integer/"""
        result = 0
        i = 0

        while i < len(s):
            if s[i] == "M":
                result += 1000
                i += 1
            elif s[i] == "C" and i < len(s) - 1 and s[i + 1] == "M":
                result += 900
                i += 2
            elif s[i] == "D":
                result += 500
                i += 1
            elif s[i] == "C" and i < len(s) - 1 and s[i + 1] == "D":
                result += 400
                i += 2
            elif s[i] == "C":
                result += 100
                i += 1
            elif s[i] == "X" and i < len(s) - 1 and s[i + 1] == "C":
                result += 90
                i += 2
            elif s[i] == "L":
                result += 50
                i += 1
            elif s[i] == "X" and i < len(s) - 1 and s[i + 1] == "L":
                result += 40
                i += 2
            elif s[i] == "X":
                result += 10
                i += 1
            elif s[i] == "I" and i < len(s) - 1 and s[i + 1] == "X":
                result += 9
                i += 2
            elif s[i] == "V":
                result += 5
                i += 1
            elif s[i] == "I" and i < len(s) - 1 and s[i + 1] == "V":
                result += 4
                i += 2
            elif s[i] == "I":
                result += 1
                i += 1
            else:
                raise ValueError("")

        return result

    def longestCommonPrefix(self, strs: List[str]) -> str:
        """Code for solving leetcode problem 14:
        https://leetcode.com/problems/longest-common-prefix/"""
        if not strs:
            return ""

        if len(strs) == 1:
            return strs[0]

        result = ""
        i = 0
        while True:
            if i >= len(strs[0]):
                break
            s_0_i = strs[0][i]
            all_equal = True
            for s in strs[1:]:
                if i >= len(s) or s[i] != s_0_i:
                    all_equal = False
                    break

            if all_equal:
                result += s_0_i
                i += 1
            else:
                break

        return result
