from typing import List

class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        pos = [x for x in nums if x > 0]
        neg = [x for x in nums if x < 0]

        res = []
        n = len(nums) // 2
        for i in range(n):
            res.append(pos[i])
            res.append(neg[i])

        return res
