
from typing import *

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []
    
        res = []
        p_cnt = [0] * 26
        window = [0] * 26

        for c in p:
            p_cnt[ord(c) - ord('a')] += 1

        for i in range(len(s)):
            window[ord(s[i]) - ord('a')] += 1

            if i >= len(p):
                window[ord(s[i - len[p]]) - ord('a')] -= 1

            if window == p_cnt:
                res.append(i - len(p) + 1)
                
        return res