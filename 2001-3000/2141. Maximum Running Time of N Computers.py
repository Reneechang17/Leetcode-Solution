# Hard
# Greedy
# Time:O(nlogn), Space:O(1)
# https://leetcode.cn/problems/maximum-running-time-of-n-computers/

from typing import *

class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        batteries.sort(reverse=True)
        total = sum(batteries)

        while batteries and batteries[0] > total // n:
            total -= batteries.pop(0)
            n -= 1
            if n == 0:
                return 0
        
        return total // n
    