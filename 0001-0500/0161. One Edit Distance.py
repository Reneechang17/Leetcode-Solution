# Time:O(n), Space:O(1)

class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        m, n = len(s), len(t)

        if abs(m - n) > 1:
            return False

        if m > n:
            return self.isOneEditDistance(t, s)

        for i in range(m):
            if s[i] != t[i]:
                if m == n:
                    return s[i + 1 :] == t[i + 1 :]
                else:
                    # s is shorter -> insert in s == skip t[i]
                    return s[i:] == t[i + 1 :]

        return n == m + 1
    