# Time:O(n+m+26), Space:O(1)

from collections import Counter

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        count_s = Counter(s)
        count_t = Counter(t)

        steps = 0
        all_chars = set(count_s.keys()) | set(count_t.keys())

        for char in all_chars:
            steps += abs(count_s[char] - count_t[char])

        return steps
