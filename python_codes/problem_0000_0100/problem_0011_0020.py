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