# Time:O(n), Space:O(k)

from typing import List

class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        stack = []
        del_num = len(nums) - k

        for num in nums:
            while stack and num < stack[-1] and del_num > 0:
                stack.pop()
                del_num -= 1
            stack.append(num)

        return stack[:k]
