# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n = len(nums1)
        nums1.sort()

        idx2 = sorted(range(n), key=lambda x: -nums2[x])

        left, right = 0, n - 1
        res = [0] * n

        for i in idx2:
            if nums1[right] > nums2[i]:
                res[i] = nums1[right]
                right -= 1
            else:
                res[i] = nums1[left]
                left += 1
        
        return res
    