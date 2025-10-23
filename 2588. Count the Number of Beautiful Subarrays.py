from typing import *

class Solution:
    def beautifulSubarrays(self, nums: List[int]) -> int:
        prefix_xor = {0: 1}

        xor = 0
        cnt = 0

        for x in nums:
            xor ^= x
            cnt += prefix_xor.get(xor, 0)
            prefix_xor[xor] = prefix_xor.get(xor, 0) + 1

        return cnt
