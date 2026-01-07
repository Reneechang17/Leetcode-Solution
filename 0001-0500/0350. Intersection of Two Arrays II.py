# Time:O(m+n), Space:O(m+n)

from typing import Counter, List

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        c1, c2 = Counter(nums1), Counter(nums2)
        res = []

        for x in c1:
            if x in c2:
                res.extend([x] * min(c1[x], c2[x]))

        return res
