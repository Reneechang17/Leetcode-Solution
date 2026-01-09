# Time:O(n²), Space:O(1)

from typing import List

class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        def diff_count(w1, w2):
            count = 0
            for i in range(len(w1)):
                if w1[i] != w2[i]:
                    count += 1
            return count

        res = []

        for query in queries:
            for word in dictionary:
                if len(query) == len(word) and diff_count(query, word) <= 2:
                    res.append(query)
                    break
        return res
