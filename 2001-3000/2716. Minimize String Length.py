# Time:O(n), Space:O(1)

class Solution:
    def minimizedStringLength(self, s: str) -> int:
        return len(set(s))
    