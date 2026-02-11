# Time:O(n), Space:O(n)

class Solution:
    def minFlips(self, s: str) -> int:
        n = len(s)
        targetA = []
        targetB = []

        for i in range(2 * n):
            if i % 2 == 0:
                targetA.append('0')
                targetB.append('1')
            else:
                targetA.append('1')
                targetB.append('0')
        
        s2 = s + s
        diffA = [1 if s2[i] != targetA[i] else 0 for i in range(2 * n)]
        diffB = [1 if s2[i] != targetB[i] else 0 for i in range(2 * n)]

        prefixA = [0] * (2*n + 1)
        prefixB = [0] * (2*n + 1)

        for i in range(2*n):
            prefixA[i + 1] = prefixA[i] + diffA[i]
            prefixB[i + 1] = prefixB[i] + diffB[i]
        
        ans = float('inf')
        for start in range(n):
            end = start + n
            cntA = prefixA[end] - prefixA[start]
            cntB = prefixB[end] - prefixB[start]
            ans = min(ans, cntA, cntB)
        
        return ans
    