# Medium
# Math
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/count-number-of-trapezoids-i/

# ............official solution looks pretty decent and smart so I cv it.

from typing import *
from collections import defaultdict

class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        point_num = defaultdict(int)
        MOD = 10**9 + 7
        ans, total_sum = 0, 0

        for point in points:
            point_num[point[1]] += 1
        
        for p_num in point_num.values():
            edge = p_num * (p_num - 1) // 2
            ans = (ans + edge * total_sum) % MOD
            total_sum = (total_sum + edge) % MOD
        
        return ans
    