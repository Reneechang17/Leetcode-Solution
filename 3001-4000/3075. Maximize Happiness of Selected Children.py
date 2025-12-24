# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        
        total = 0

        for i in range(k):
            cur_value = happiness[i] - i
            if cur_value < 0:
                cur_value = 0
            
            total += cur_value
        
        return total
        