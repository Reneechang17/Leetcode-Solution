# Time:O(nm), Space:O(1)

from typing import List

class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        ans = 0
        for x in arr1:
            if all(abs(x - y) > d for y in arr2):
                ans += 1
                
        return ans

# Can optimize use binary search
