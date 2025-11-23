# Medium
# Stack, Greedy
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/maximum-score-from-removing-substrings/

class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        def remove_pair(s, first, second, points):
            stack = []
            score = 0
            for c in s:
                if c == second and stack and stack[-1] == first:
                    stack.pop()
                    score += points
                else:
                    stack.append(c)
            return ''.join(stack), score
        
        if x >= y:
            s, score1 = remove_pair(s, 'a', 'b', x)
            s, score2 = remove_pair(s, 'b', 'a', y)
        else:
            s, score1 = remove_pair(s, 'b', 'a', y)
            s, score2 = remove_pair(s, 'a', 'b', x)
        
        return score1 + score2
    