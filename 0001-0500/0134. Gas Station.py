# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total = 0
        cur_tank = 0
        start = 0

        for i in range(len(gas)):
            gain = gas[i] - cost[i] # from i -> i+1
            total += gain
            cur_tank += gain

            if cur_tank < 0:
                start = i + 1
                cur_tank = 0
        
        return start if total >= 0 else -1
    