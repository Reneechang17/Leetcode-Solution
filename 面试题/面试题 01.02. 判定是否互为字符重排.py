# Time:O(n), Space:O(1) limit in 100

class Solution:
    def CheckPermutation(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2):
            return False
        
        cnt = [0] * 26
        for c in s1:
            cnt[ord(c) - ord('a')] += 1
        for c in s2:
            cnt[ord(c) - ord('a')] -= 1
            if cnt[ord(c) - ord('a')] < 0:
                return False
        return True
    