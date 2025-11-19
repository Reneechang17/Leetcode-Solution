# Medium
# Greedy, Set
# Time:O(n + k log k), Space:O(k)
# https://leetcode.cn/problems/minimum-deletions-to-make-character-frequencies-unique/

class Solution:
    def minDeletions(self, s: str) -> int:
        from collections import Counter
        
        freq = Counter(s)

        sorted_freq = sorted(freq.values(), reverse=True)

        used = set()
        deletions = 0

        for f in sorted_freq:
            while f > 0 and f in used:
                f -= 1
                deletions += 1
            if f > 0:
                used.add(f)

        return deletions
