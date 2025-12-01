# Medium
# String
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/repeated-dna-sequences/

from typing import List

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s) < 10:
            return []
        
        seen = set()
        res = set()

        for i in range(len(s) - 9):
            sub_str = s[i:i+10]
            if sub_str in seen:
                res.add(sub_str)
            else:
                seen.add(sub_str)

        return list(res)
    