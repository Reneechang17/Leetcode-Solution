# Time:O(nlogn), Space:O(n)

from typing import Counter

class Solution:
    def frequencySort(self, s: str) -> str:
        count = Counter(s)

        sorted_chars= sorted(count.items(), key=lambda x:x[1], reverse=True)

        res = []
        for c, freq in sorted_chars:
            res.append(c * freq)

        return ''.join(res)
    