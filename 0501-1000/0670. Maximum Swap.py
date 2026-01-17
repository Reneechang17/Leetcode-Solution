# Time:O(n), Space:O(n)

class Solution:
    def maximumSwap(self, num: int) -> int:
        s = list(str(num))
        n = len(s)

        last = {int(d): i for i, d in enumerate(s)}

        for i in range(n):
            digit = int(s[i])
            for d in range(9, digit, -1):
                if d in last and last[d] > i:
                    s[i], s[last[d]] = s[last[d]], s[i]
                    return int("".join(s))

        return num
