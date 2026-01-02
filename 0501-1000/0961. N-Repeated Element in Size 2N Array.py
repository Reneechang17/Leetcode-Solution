# Time:O(n), Space:O(n)

from typing import List, Counter

class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        count = Counter(nums)
        n = len(nums) // 2
        
        for x, freq in count.items():
            if freq == n:
                return x
    