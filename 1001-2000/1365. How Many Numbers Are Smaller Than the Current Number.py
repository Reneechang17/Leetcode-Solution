# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        sorted_num = sorted(nums)

        first_idx = {}
        for i in range(len(sorted_num)):
            if sorted_num[i] not in first_idx:
                first_idx[sorted_num[i]] = i

        res = []
        for num in nums:
            res.append(first_idx[num])

        return res
