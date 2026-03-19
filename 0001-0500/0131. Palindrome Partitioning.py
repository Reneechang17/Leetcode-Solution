# Time:O(n × 2ⁿ), Space:O(n)

from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        path = []

        def is_palindrome(sub):
            return sub == sub[::-1]

        def backtracking(start):
            if start == len(s):
                res.append(path[:])
                return
            
            for end in range(start, len(s)):
                sub = s[start:end + 1]
                if is_palindrome(sub):
                    path.append(sub)
                    backtracking(end + 1)
                    path.pop()

        backtracking(0)
        return res
    