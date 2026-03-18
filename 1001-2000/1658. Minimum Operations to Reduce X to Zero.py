# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        # 相当于找最长连续子数组，和为total - x
        total = sum(nums)
        target = total - x
        n = len(nums)

        if target < 0:
            return -1
        if target == 0:
            return n
        
        left = 0
        cur_sum = 0
        max_len = -1

        for right in range(n):
            cur_sum += nums[right]

            while cur_sum > target:
                cur_sum -= nums[left]
                left += 1
            
            if cur_sum == target:
                max_len = max(max_len, right - left + 1)
            
        return n - max_len if max_len != -1 else -1
    