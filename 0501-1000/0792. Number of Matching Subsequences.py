# Medium
# Binary Search
# Time:O(n+ words'len * logn), Space:O(n)
# https://leetcode.cn/problems/number-of-matching-subsequences/

from typing import *

class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        from collections import defaultdict

        # record the pos of each char in s
        char_pos = defaultdict(list)
        for i, c in enumerate(s):
            char_pos[c].append(i)

        cnt = 0

        for word in words:
            prev_pos = -1
            is_subseq = True

            for c in word:
                pos = char_pos[c]

                # binary search to find the first > prev_pos
                # valid subseq must on right side
                left, right = 0, len(pos)
                while left < right:
                    mid = (left + right) // 2
                    if pos[mid] <= prev_pos:
                        left = mid + 1
                    else:
                        right = mid

                if left == len(pos):
                    is_subseq = False
                    break

                prev_pos = pos[left]
            
            if is_subseq:
                cnt += 1

        return cnt
