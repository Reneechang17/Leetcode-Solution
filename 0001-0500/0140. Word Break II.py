# Time:O(n × 2^n), Space:O(n × 2^n)

from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        word_set = set(wordDict)
        memo = {}

        def backtracking(start):
            if start in memo:
                return memo[start]

            if start == len(s):
                return [[]]

            res = []

            for end in range(start + 1, len(s) + 1):
                word = s[start:end]
                if word in word_set:
                    sub_res = backtracking(end)
                    for sub in sub_res:
                        res.append([word] + sub)

            memo[start] = res
            return res

        sentences = backtracking(0)
        return [" ".join(w) for w in sentences]
