# Time:(m*n*S), Space:O(S)

from typing import List

class Solution:
    def minimizeTheDifference(self, mat: List[List[int]], target: int) -> int:
        dp = {0}

        for row in mat:
            new_dp = set()
            for val in row:
                for s in dp:
                    new_dp.add(s + val)
            dp = new_dp
        
        ans = float('inf')
        for s in dp:
            ans = min(ans, abs(s - target))
        
        return ans
    