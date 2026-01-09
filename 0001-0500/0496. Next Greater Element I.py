# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        next = {}
        stack = []

        for num in nums2:
            while stack and stack[-1] < num:
                next[stack.pop()] = num
            stack.append(num)

        for num in stack:
            next[num] = -1

        res = []
        for num in nums1:
            res.append(next[num])

        return res
