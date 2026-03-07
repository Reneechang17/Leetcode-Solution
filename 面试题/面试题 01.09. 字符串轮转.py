# Time:O(n), Space:O(n)

class Solution:
    def isFlipedString(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2):
            return False
        if not s1:
            return True
        return s2 in (s1 + s1)
    