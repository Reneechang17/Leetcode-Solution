# Time:O(n), Space:O(1)

class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        n = len(s)
        cnt = [0, 0, 0]
        left = 0
        ans = 0

        for right, c in enumerate(s):
            cnt[ord(c) - ord('a')] += 1
            
            while cnt[0] and cnt[1] and cnt[2]:
                ans += n - right
                cnt[ord(s[left]) - ord('a')] -= 1
                left += 1
        
        return ans
    