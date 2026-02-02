# Time:O(n), Space:O(min(n,k))

from typing import List

class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        mod_map = {0: -1} # mod -> first appear idx
        prefix = 0

        for i, num in enumerate(nums):
            prefix += num

            if k != 0:
                prefix %= k
            
            if prefix in mod_map:
                # len should >= 2
                if i - mod_map[prefix] > 1:
                    return True
            else:
                mod_map[prefix] = i
        
        return False
    