# Time:O(1), Space:O(1)

class Solution:
    def convertTime(self, current: str, correct: str) -> int:

        def to_minutes(t: str) -> int:
            h, m = map(int, t.split(':'))
            return h * 60 + m

        diff = to_minutes(correct) - to_minutes(current)
        ops = 0
        for step in [60, 15, 5, 1]:
            ops += diff // step
            diff %= step
        
        return ops
    