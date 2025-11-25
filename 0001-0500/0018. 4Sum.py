# Medium
# Two Pointers, Sorting
# Time:O(n^3), Space:O(1)
# https://leetcode.cn/problems/4sum/

from typing import *

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        res = []
        n = len(nums)

        for i in range(n - 3):
            # skip dup for first num
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # nested loop
            for j in range(i + 1, n - 2):
                # skip dup for second num
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                
                left, right = j + 1, n - 1
                remain = target - nums[i] - nums[j]

                while left < right:
                    cur_sum = nums[left] + nums[right]
                    if cur_sum == remain:
                        res.append([nums[i], nums[j], nums[left], nums[right]])

                        # skip dup for left & right
                        while left < right and nums[left] == nums[left + 1]:
                            left += 1
                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1
                        
                        left += 1
                        right -= 1
                    elif cur_sum < remain:
                        left += 1
                    else:
                        right -= 1
        return res
    