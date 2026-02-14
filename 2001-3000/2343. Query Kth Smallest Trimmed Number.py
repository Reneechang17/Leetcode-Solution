# Time:O(q × nlogn), Space:O(n)

from typing import List

class Solution:
    def smallestTrimmedNumbers(self, nums: List[str], queries: List[List[int]]) -> List[int]:
        res = []
        for k, trim in queries:
            pairs = []
            for i, num in enumerate(nums):
                trimmed = num[-trim:]
                pairs.append((trimmed, i))
            
            pairs.sort(key=lambda x: (x[0], x[1]))
            res.append(pairs[k - 1][1])
        
        return res
    