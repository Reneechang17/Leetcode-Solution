# Time:O(n), Space:O(1)

from collections import Counter

class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        c_count = Counter(s)
        if c_count["a"] < k or c_count["b"] < k or c_count["c"] < k:
            return -1

        n = len(s)
        max_window = 0
        left = 0
        window_count = Counter()

        for right in range(n):
            window_count[s[right]] += 1

            while (
                c_count["a"] - window_count["a"] < k
                or c_count["b"] - window_count["b"] < k
                or c_count["c"] - window_count["c"] < k
            ):
                window_count[s[left]] -= 1
                left += 1

            max_window = max(max_window, right - left + 1)

        return n - max_window
    