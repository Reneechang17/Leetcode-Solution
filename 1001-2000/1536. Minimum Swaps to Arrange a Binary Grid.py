# Time:O(n²), Space:O(n)

from typing import List

class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        n = len(grid)
        last_one = []
        for i in range(n):
            j = n - 1
            while j >= 0 and grid[i][j] == 0:
                j -= 1
            last_one.append(j)
        
        ans = 0
        for i in range(n):
            # find the first last_one[row] <= i
            target = -1
            for row in range(i, n):
                if last_one[row] <= i:
                    target = row
                    break
            if target == -1:
                return -1
            
            # swap target and i
            for row in range(target, i, -1):
                last_one[row], last_one[row - 1] = last_one[row - 1], last_one[row]
                ans += 1
        
        return ans
    