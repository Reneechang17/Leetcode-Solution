# Time:O(n * 2^n), Space:O(n)

from typing import List

class Solution:
    def generateAbbreviations(self, word: str) -> List[str]:
        res = []

        def backtracking(index, path, count):
            if index == len(word):
                res.append(path + (str(count) if count > 0 else ""))
                return
            
            # cnt + 1
            backtracking(index + 1, path, count + 1)

            # keep current
            backtracking(
                index + 1, path + (str(count) if count > 0 else "") + word[index], 0
            )

        backtracking(0, "", 0)
        return res
    