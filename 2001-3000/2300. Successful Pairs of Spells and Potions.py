# Time:O(m log m + n log m)
# Space:O(1)

from typing import List

class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        n = len(potions)
        ans = []

        for s in spells:
            # s*p >= success
            # p >= ceil(success/s)
            target = (success + s - 1) // s

            left, right = 0, n
            while left < right:
                mid = (left + right) // 2
                if potions[mid] < target:
                    left = mid + 1
                else:
                    right = mid
            
            ans.append(n - left)
        
        return ans
    