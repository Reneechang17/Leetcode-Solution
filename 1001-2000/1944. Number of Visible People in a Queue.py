# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        n = len(heights)
        res = [0] * n
        stack = []

        for i in range(n - 1, -1, -1):
            count = 0

            # pop shorter that current can see
            while stack and heights[stack[-1]] < heights[i]:
                stack.pop()
                count += 1
            
            if stack:
                # can see one more(taller then cur)
                count += 1
            
            res[i] = count
            stack.append(i)
        
        return res
    