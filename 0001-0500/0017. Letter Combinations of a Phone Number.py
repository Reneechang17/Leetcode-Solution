# Time: O(4^n), Space:O(n)

from typing import *

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        
        phone = {
            '2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
            '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'
        }

        res = []

        def backtracking(index, path):
            if index == len(digits):
                res.append(path)
                return
            
            letters = phone[digits[index]]
            for letter in letters:
                backtracking(index + 1, path + letter)
        
        backtracking(0, "")
        return res
