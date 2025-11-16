# Easy
# String, Sliding Window
# Time:O(n²), Space:O(1)
# https://leetcode.cn/problems/count-vowel-substrings-of-a-string/

class Solution:
    def countVowelSubstrings(self, word: str) -> int:
        vowels = set('aeiou')
        res = 0
        n = len(word)

        for i in range(n):
            if word[i] not in vowels:
                continue

            vis = set()
            for j in range(i, n):
                if word[j] not in vowels:
                    break
                vis.add(word[j])
                if len(vis) == 5:
                    res += 1

        return res
    