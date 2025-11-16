# Medium
# Hash Table, Simulation
# Time:O(n), Space:O(k)
# https://leetcode.cn/problems/maximize-distance-to-closest-person/

from typing import *

class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        n = len(seats)
        max_dist = 0
        prev = -1

        for i in range(n):
            if seats[i] == 1:
                if prev == -1:
                    max_dist = i 
                else:
                    max_dist = max(max_dist, (i - prev) // 2)
                prev = i
        
        max_dist = max(max_dist, n - 1 - prev)

        return max_dist
