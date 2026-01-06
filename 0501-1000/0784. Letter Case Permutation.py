# Time:O(n*2^m), Space:O(n)

from typing import List

class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        res = []

        def backtracking(index, path):
            if index == len(s):
                res.append(path)
                return

            char = s[index]
            if char.isalpha():
                backtracking(index + 1, path + char.lower())
                backtracking(index + 1, path + char.upper())
            else:
                backtracking(index + 1, path + char)

        backtracking(0, "")
        return res
    