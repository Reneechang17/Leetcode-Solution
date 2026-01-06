# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        cand1 = cand2 = None
        count1 = count2 = 0

        for x in nums:
            if x == cand1:
                count1 += 1
            elif x == cand2:
                count2 += 1
            elif count1 == 0:
                cand1 = x
                count1 = 1
            elif count2 == 0:
                cand2 = x
                count2 = 1
            else:
                count1 -= 1
                count2 -= 1

        res = []
        threshold = len(nums) // 3

        for cand in [cand1, cand2]:
            if cand is not None and nums.count(cand) > threshold:
                res.append(cand)

        return res
