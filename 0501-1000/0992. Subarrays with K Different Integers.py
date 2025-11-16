# Hard
# Sliding Window. Hash Table
# Time:O(n), Space:O(n) 
# https://leetcode.cn/problems/subarrays-with-k-different-integers/

# exactly(k) = atMost(k) - atMost(k-1)

from typing import *

class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        def atMostK(k):
            from collections import defaultdict
            cnt = defaultdict(int)
            left = 0
            res = 0

            for right in range(len(nums)):
                if cnt[nums[right]] == 0: 
                    k -= 1
                cnt[nums[right]] += 1

                while k < 0:
                    cnt[nums[left]] -= 1
                    if cnt[nums[left]] == 0:
                        k += 1
                    left += 1
                
                res += right - left + 1
            return res
        
        return atMostK(k) - atMostK(k - 1)
