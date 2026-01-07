# Time:O(m+n), Space:O(m+n)

from typing import List

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        set1 = set(nums1)
        res = set()

        for x in nums2:
            if x in set1:
                res.add(x)
        
        return list(res)
    