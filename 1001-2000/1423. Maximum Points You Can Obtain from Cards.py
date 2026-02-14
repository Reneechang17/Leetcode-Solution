# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n = len(cardPoints)
        total = sum(cardPoints)
        if k == n:
            return total
        
        window = n - k
        cur_sum = sum(cardPoints[:window])
        min_sum = cur_sum

        for i in range(window, n):
            cur_sum += cardPoints[i] - cardPoints[i - window]
            min_sum = min(min_sum, cur_sum)
        
        return total - min_sum
    