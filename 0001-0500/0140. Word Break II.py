# Time:O(n*k), Space:O(n)

from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        word_set = set(wordDict)
        memo = {} # start_idx -> list of sentences

        def dfs(start):
            if start == len(s):
                return [""]
            
            if start in memo:
                return memo[start]
            
            res = []
            for end in range(start + 1, len(s) + 1):
                word = s[start:end]
                if word in word_set:
                    # from end, which sub can form the valid sentence
                    suffix = dfs(end)
                    for suf in suffix:
                        if suf:
                            res.append(word + " " + suf)
                        else:
                            res.append(word)
            memo[start] = res
            return res

        return dfs(0)
