# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_sum = 0
        cnt = 0 
        prefix = {0: 1} 

        for num in nums:
            prefix_sum += num
            # if prefix_sum - k exists in map
            # means this subarr's sum is k
            if prefix_sum - k in prefix:
                cnt += prefix[prefix_sum - k]
            prefix[prefix_sum] = prefix.get(prefix_sum, 0) + 1
        
        return cnt
    
# follow-up: what if negative or 0 in arr change the res??
# Ans: no. But sliding window isn't work in that case
    