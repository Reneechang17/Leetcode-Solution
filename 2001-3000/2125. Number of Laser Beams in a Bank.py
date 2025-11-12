# Medium
# Simulation
# Time:O(mn), Space:O(1)
# https://leetcode.cn/problems/number-of-laser-beams-in-a-bank/

from typing import *

class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        total = 0
        prev_devices = 0

        for r in bank:
            cur_devices = r.count('1')

            if cur_devices > 0:
                total += prev_devices * cur_devices
                prev_devices = cur_devices
            
        return total
