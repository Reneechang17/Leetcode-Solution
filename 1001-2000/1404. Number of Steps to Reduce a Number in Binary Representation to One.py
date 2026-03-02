# Time:O(n), Space:O(1)

class Solution:
    def numSteps(self, s: str) -> int:
        steps = 0
        carry = 0

        for i in range(len(s) - 1, 0, -1):
            d = int(s[i]) + carry
            if d % 2 == 1:
                steps += 2
                carry = 1
            elif d == 2:
                steps += 1
                carry = 1
            else:
                steps += 1
                carry = 0
        
        return steps + carry
    