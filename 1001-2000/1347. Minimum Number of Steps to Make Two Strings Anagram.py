# Time:O(n), Space:O(1)

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        cnt = [0] * 26

        for c in s:
            cnt[ord(c) - ord('a')] += 1
        for c in t:
            cnt[ord(c) - ord('a')] -= 1
        
        ans = 0
        for x in cnt:
            if x > 0:
                ans += x
        
        return ans
    