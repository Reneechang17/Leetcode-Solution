# Time:O(n), Space:O(1)

from typing import Counter

class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        count = Counter(s)
        odd_count = 0
        for freq in count.values():
            if freq % 2 == 1:
                odd_count += 1

        return odd_count <= 1
    