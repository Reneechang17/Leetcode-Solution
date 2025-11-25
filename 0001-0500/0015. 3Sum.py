# Medium
# Two Pointers, Sorting
# Time:O(n^2), Space:O(1)
# https://leetcode.cn/problems/3sum/

from typing import *

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        n = len(nums)

        for i in range(n - 2):
            # skip dup for first num
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # prune: if first num > 0 -> impossible to find solution
            if nums[0] > 0:
                break

            left, right = i + 1, n - 1
            target = -nums[i]

            while left < right:
                cur_sum = nums[left] + nums[right]
                if cur_sum == target:
                    res.append([nums[i], nums[left], nums[right]])

                    # skip dup left & right
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    
                    left += 1
                    right -= 1     
                elif cur_sum < target:
                    left += 1 # use bigger num
                else:
                    right -= 1

        return res
