# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n = len(prices)
        res = prices[:]
        stack = []

        for i in range(n - 1, -1, -1):
            while stack and stack[-1] > prices[i]:
                stack.pop()
            if stack:
                res[i] -= stack[-1]
            
            stack.append(prices[i])
        
        return res
    