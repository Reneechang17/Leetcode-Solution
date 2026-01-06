# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        sorted_nums = sorted(nums)

        mid = (n + 1) // 2
        small = sorted_nums[:mid][::-1]
        large = sorted_nums[mid:][::-1]

        for i in range(len(small)):
            nums[2 * i] = small[i]
        for i in range(len(large)):
            nums[2 * i + 1] = large[i]
