# Time:O(n logn), Space:O(n)

from typing import List

class Solution:
    def visibleMountains(self, peaks: List[List[int]]) -> int:
        intervals = [(x - y, x + y) for x, y in peaks]

        # left asc, right desc
        intervals.sort(key=lambda x: (x[0], -x[1]))

        ans = 0
        max_right = float('-inf')
        n = len(intervals)

        i = 0
        while i < n:
            l, r = intervals[i]

            dup = False
            if i < n - 1 and intervals[i] == intervals[i + 1]:
                dup = True
                while i < n - 1 and intervals[i] == intervals[i + 1]:
                    i += 1
            
            if r > max_right:
                if not dup:
                    ans += 1
                max_right = r
            
            i += 1
        
        return ans
    