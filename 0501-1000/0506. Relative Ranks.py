# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        n = len(score)
        pairs = [(score[i], i) for i in range(n)]
        pairs.sort(reverse=True)

        res = [""] * n
        for rank, (_, idx) in enumerate(pairs):
            if rank == 0:
                res[idx] = "Gold Medal"
            elif rank == 1:
                res[idx] = "Silver Medal"
            elif rank == 2:
                res[idx] = "Bronze Medal"
            else:
                res[idx] = str(rank + 1)
        
        return res
    