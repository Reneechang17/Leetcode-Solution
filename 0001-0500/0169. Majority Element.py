# Time:O(n), Space:O(1)

# use Boyer-Moore algo.

from typing import List

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        cand = None
        count = 0

        for x in nums:
            if count == 0:
                cand = x

            if x == cand:
                count += 1
            else:
                count -= 1

        return cand
