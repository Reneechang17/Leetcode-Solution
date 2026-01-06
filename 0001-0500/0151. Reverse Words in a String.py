# Time:O(n), Space:O(n)

class Solution:
    def reverseWords(self, s: str) -> str:
        words = []
        word = []

        for c in s:
            if c != " ":
                word.append(c)
            elif word:
                words.append("".join(word))
                word = []

        if word:
            words.append("".join(word))

        rev = []
        for i in range(len(words) - 1, -1, -1):
            rev.append(words[i])

        res = []
        for i in range(len(rev)):
            res.append(rev[i])
            if i < len(rev) - 1:
                res.append(" ")

        return "".join(res)
