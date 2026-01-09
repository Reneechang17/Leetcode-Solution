# Time:O(n), Space:O(1)

from typing import Counter

class Solution:
    def firstUniqChar(self, s: str) -> int:
        count = Counter(s)

        for i, c in enumerate(s):
            if count[c] == 1:
                return i
                
        return -1
    