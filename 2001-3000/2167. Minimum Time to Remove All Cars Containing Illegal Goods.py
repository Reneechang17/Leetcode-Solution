# Time:O(n), Space:O(n)

class Solution:
    def minimumTime(self, s: str) -> int:
        n = len(s)
        left = [0] * (n + 1)
        right = [0] * (n + 1)

        for i in range(n):
            if s[i] == '1':
                left[i + 1] = min(left[i] + 2, i + 1)
            else:
                left[i + 1] = left[i]
        
        for i in range(n - 1, -1, -1):
            if s[i] == '1':
                right[i] = min(right[i + 1] + 2, n - i)
            else:
                right[i] = right[i + 1]
        
        ans = n
        for i in range(n + 1):
            ans = min(ans, left[i] + right[i])
        
        return ans
    