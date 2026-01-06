# Time:O(m*n),Space:O(1)

class Solution:
    def minWindow(self, s1: str, s2: str) -> str:
        m, n = len(s1), len(s2)
        min_len = float("inf")
        res = ""

        i = 0

        while i < m:
            j = 0

            while i < m and j < n:
                if s1[i] == s2[j]:
                    j += 1
                i += 1

            if j < n:
                break

            end = i - 1

            i -= 1
            j -= 1

            while j >= 0:
                if s1[i] == s2[j]:
                    j -= 1
                i -= 1

            i += 1

            window_len = end - i + 1
            if window_len < min_len:
                min_len = window_len
                res = s1[i : end + 1]

            i += 1

        return res
    