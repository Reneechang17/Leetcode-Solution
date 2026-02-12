# Time:O(k), Space:O(k)

class Solution:
    def thousandSeparator(self, n: int) -> str:
        s = str(n)
        res = []
        cnt = 0

        for i in range(len(s) - 1, -1, -1):
            res.append(s[i])
            cnt += 1
            if cnt % 3 == 0 and i != 0:
                res.append('.')
        
        return ''.join(reversed(res))
    