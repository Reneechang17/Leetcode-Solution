# Time:O(n), Space:O(k)

from typing import List

class Solution:
    def maxSum(self, nums: List[int], m: int, k: int) -> int:
        n = len(nums)
        if n < k:
            return 0
        
        freq = {}
        cur_sum = 0
        max_sum = 0

        for i in range(k):
            freq[nums[i]] = freq.get(nums[i], 0) + 1
            cur_sum += nums[i]
        
        if len(freq) >= m:
            max_sum = cur_sum
        
        for i in range(k, n):
            left = nums[i - k]
            freq[left] -= 1
            if freq[left] == 0:
                del freq[left]
            cur_sum -= left

            right = nums[i]
            freq[right] = freq.get(right, 0) + 1
            cur_sum += right

            if len(freq) >= m:
                max_sum = max(max_sum, cur_sum)
        
        return max_sum
    