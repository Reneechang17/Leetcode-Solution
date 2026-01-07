# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def maximumSetSize(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        s1, s2 = set(nums1), set(nums2)

        only1 = s1 - s2
        only2 = s2 - s1
        common = s1 & s2

        q1, q2 = n // 2, n // 2

        n1_unique = min(len(only1), q1)
        remain1 = q1 - n1_unique

        n2_unique = min(len(only2), q2)
        remain2 = q2 - n2_unique

        common_used = min(len(common), remain1 + remain2)

        return n1_unique + n2_unique + common_used
