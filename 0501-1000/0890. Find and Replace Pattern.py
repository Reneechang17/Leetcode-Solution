# Time:O(n*m), Space:O(1)

from typing import List

class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        def is_match(word, pattern):
            if len(word) != len(pattern):
                return False

            word_to_pat = {}
            pat_to_word = {}

            for i in range(len(word)):
                w = word[i]
                p = pattern[i]

                if w in word_to_pat:
                    if word_to_pat[w] != p:
                        return False
                else:
                    word_to_pat[w] = p

                if p in pat_to_word:
                    if pat_to_word[p] != w:
                        return False
                else:
                    pat_to_word[p] = w

            return True

        res = []
        for word in words:
            if is_match(word, pattern):
                res.append(word)
        return res
