# Time:O(n), Space:O(m)

from typing import List

class Solution:
    def numberOfGoodSubarraySplits(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        ones = [i for i, num in enumerate(nums) if num == 1]

        if not ones:
            return 0

        if len(ones) == 1:
            return 1

        res = 1
        for i in range(1, len(ones)):
            gap = ones[i] - ones[i - 1] - 1
            res = (res * (gap + 1)) % MOD

        return res
