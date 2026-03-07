# Time:O(n), Space:O(n)

from typing import Counter

class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        cnt = Counter(s)
        odd = sum(1 for v in cnt.values() if v % 2 == 1)
        return odd <= 1
    