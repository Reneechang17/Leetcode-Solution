# Time:O(1), Space:O(1)

class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        total = 2 * (n - 1)
        t = time % total

        if t <= n - 1:
            return t + 1
        else:
            return 2 * n - t - 1
        