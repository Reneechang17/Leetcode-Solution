# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/find-mirror-score-of-a-string/

class Solution:
    def calculateScore(self, s: str) -> int:
        score = 0
        ava = {}

        for i, c in enumerate(s):
            # thie core is this line:D
            mirror = chr(ord('z') - (ord(c) - ord('a')))

            if mirror in ava and ava[mirror]:
                prev = ava[mirror].pop()
                score += i - prev
            else:
                if c not in ava:
                    ava[c] = []
                ava[c].append(i)
        return score
    