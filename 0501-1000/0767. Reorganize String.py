# Medium
# Array, Greedy
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/reorganize-string/

from collections import Counter

class Solution:
    def reorganizeString(self, s: str) -> str:
        count = Counter(s)
        max_char = max(count, key=count.get)

        if count[max_char] > (len(s) + 1) // 2:
            return ""
        
        res = [''] * len(s)
        index = 0

        for _ in range(count[max_char]):
            res[index] = max_char
            index += 2
        
        del count[max_char]

        for char, freq in count.items():
            for _ in range(freq):
                if index >= len(s):
                    index = 1
                res[index] = char
                index += 2
        
        return ''.join(res)
    