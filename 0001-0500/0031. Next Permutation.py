# Time:O(n), Space:O(1)

# find the first nums[i]<nums[i+1] from right to left
# find the first pos j nums[j]>nums[i] from right to left
# swap nums[i] and nums[j]
# reverse subarray [i+1:]

from typing import List

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        n = len(nums)

        i = n - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1

        if i >= 0:
            j = n - 1
            while nums[j] <= nums[i]:
                j -= 1

            nums[i], nums[j] = nums[j], nums[i]

        nums[i + 1 :] = reversed(nums[i + 1 :])
