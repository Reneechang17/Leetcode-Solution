# Time:O(n), Space:O(n)

from collections import Counter

class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        cnt = Counter(s)
        return len(set(cnt.values())) == 1
    