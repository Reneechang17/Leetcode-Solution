# Time:O(k × (m + n)²), Space:O(k)

from typing import List

class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        def max_subseq(nums, length):
            stack = []
            drop = len(nums) - length

            for x in nums:
                while stack and stack[-1] < x and drop > 0:
                    stack.pop()
                    drop -= 1
                stack.append(x)
            return stack[:length]
        
        def merge(seq1, seq2):
            res = []
            while seq1 or seq2:
                if seq1 > seq2:
                    res.append(seq1[0])
                    seq1 = seq1[1:]
                else:
                    res.append(seq2[0])
                    seq2 = seq2[1:]
            return res

        max_res = []
        for i in range(max(0, k - len(nums2)), min(k, len(nums1)) + 1):
            seq1 = max_subseq(nums1, i)
            seq2 = max_subseq(nums2, k - i)
            cand = merge(seq1, seq2)
            max_res = max(max_res, cand)
        
        return max_res
    