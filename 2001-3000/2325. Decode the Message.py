# Easy
# Simulation
# Time:, Space:
# https://leetcode.cn/problems/decode-the-message/

class Solution:
    def decodeMessage(self, key: str, message: str) -> str:
        mapping = {}
        char = 'a'

        for c in key:
            if c != ' ' and c not in mapping:
                mapping[c] = char
                char = chr(ord(char) + 1)

        res = []
        for c in message:
            if c == ' ':
                res.append(' ')
            else:
                res.append(mapping[c])

        return ''.join(res)
    