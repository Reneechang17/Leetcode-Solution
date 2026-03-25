# Time:O(k × 2ⁿ), Space:O(n)

from typing import List

class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        total = sum(nums)
        if total % k != 0:
            return False
        
        target = total // k
        nums.sort(reverse=True)

        if nums[0] > target:
            return False
        
        n = len(nums)
        used = [False] * n

        def backtracking(start, cur_sum, sub_cnt):
            if sub_cnt == k:
                return True
            
            if cur_sum == target:
                return backtracking(0, 0, sub_cnt + 1)
            
            for i in range(start, n):
                if not used[i] and cur_sum + nums[i] <= target:
                    used[i] = True
                    if backtracking(i + 1, cur_sum + nums[i], sub_cnt):
                        return True
                    used[i] = False

                    # cur_sum means current subset have no element
                    # if we choose nums[i] as the first element and return False
                    # any else using nums[i] as first element cannot form the valid
                    if cur_sum == 0:
                        return False

                    while i + 1 < n and nums[i + 1] == nums[i]:
                        i += 1

            return False
            
        return backtracking(0, 0, 0) # start, cur_sum, sub_cnt
    