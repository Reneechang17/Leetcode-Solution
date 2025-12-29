# Time:O(n), Space:O(n)

from typing import List
from collections import Counter

class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        count = Counter(tasks)
        ans = 0

        for freq in count.values():
            if freq == 1:
                return -1
            elif freq % 3 == 0:
                ans += freq // 3
            else:
                ans += freq // 3 + 1 # round up

        return ans
    