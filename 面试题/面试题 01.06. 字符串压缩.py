# Time:O(n), Space:O(n)

class Solution:
    def compressString(self, S: str) -> str:
        if not S:
            return S

        res = []
        cnt = 1
        for i in range(1, len(S)):
            if S[i] == S[i - 1]:
                cnt += 1
            else:
                res.append(S[i - 1] + str(cnt))
                cnt = 1 # reset
        
        # last group
        res.append(S[-1] + str(cnt))

        res = ''.join(res)
        if len(res) < len(S):
            return res
        return S
    