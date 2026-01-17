# Time:O(k × (m + n)²), Space:O(k)

from typing import List

class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        def max_subsequence(nums, k):
            drop = len(nums) - k
            stack = []
            for num in nums:
                while drop and stack and stack[-1] < num:
                    stack.pop()
                    drop -= 1
                stack.append(num)
            return stack[:k]

        def merge(a, b):
            ret = []
            i, j = 0, 0
            while i < len(a) or j < len(b):
                if a[i:] > b[j:]:
                    ret.append(a[i])
                    i += 1
                else:
                    ret.append(b[j])
                    j += 1
            return ret

        res = []

        for i in range(max(0, k - len(nums2)), min(k, len(nums1)) + 1):
            sub1 = max_subsequence(nums1, i)
            sub2 = max_subsequence(nums2, k - i)
            cand = merge(sub1, sub2)
            if cand > res:
                res = cand

        return res
    