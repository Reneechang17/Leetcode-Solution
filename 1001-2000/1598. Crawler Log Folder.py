# Easy
# Simulation
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/crawler-log-folder/

from typing import *

class Solution:
    def minOperations(self, logs: List[str]) -> int:
        depth = 0

        for ops in logs:
            if ops == "../":
                depth = max(0, depth - 1)
            elif ops == "./":
                pass
            else:
                depth += 1
        return depth
