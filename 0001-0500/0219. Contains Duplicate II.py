# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        vis = set()

        for i, num in enumerate(nums):
            if num in vis:
                return True
            vis.add(num)

            if len(vis) > k:
                vis.remove(nums[i - k])
        
        return False
    