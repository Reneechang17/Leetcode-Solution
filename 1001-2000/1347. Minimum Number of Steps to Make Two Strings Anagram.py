# Time:O(n), Space:O(1)

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        count = [0] * 26

        for c in s:
            count[ord(c) - ord('a')] += 1
        for c in t:
            count[ord(c) - ord('a')] -= 1
        
        steps = 0
        for c in count:
            if c > 0:
                steps += c
        return steps
    