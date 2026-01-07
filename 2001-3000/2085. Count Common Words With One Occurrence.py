# Time:O(m+n), Space:O(m+n)

from typing import Counter, List

class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        c1, c2 = Counter(words1), Counter(words2)

        res = 0
        for w in c1:
            if c1[w] == 1 and c2[w] == 1:
                res += 1

        return res
