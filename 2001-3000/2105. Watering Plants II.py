# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        n = len(plants)
        left, right = 0, n - 1
        waterA, waterB = capacityA, capacityB
        ans = 0

        while left < right:
            # Alice do left side
            if waterA < plants[left]:
                ans += 1
                waterA = capacityA
            waterA -= plants[left]
            left += 1

            # Bob do right side
            if waterB < plants[right]:
                ans += 1
                waterB = capacityB
            waterB -= plants[right]
            right -= 1
        
        if left == right:
            if waterA >= waterB:
                if waterA < plants[left]:
                    ans += 1
            else:
                if waterB < plants[left]:
                    ans += 1
        
        return ans
