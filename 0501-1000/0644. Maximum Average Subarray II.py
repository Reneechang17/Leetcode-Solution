# Time:O(n log(range/eps)), Space:O(n)

from typing import List

class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        n = len(nums)
        lo, hi = min(nums), max(nums)

        def can(mid):
            prefix = [0] * (n + 1)
            # prefix[i]=sum(nums[0..i-1]) - mid*i
            for i in range(1, n + 1):
                prefix[i] = prefix[i - 1] + nums[i - 1] - mid

            min_prefix = 0
            for i in range(k, n + 1):
                min_prefix = min(min_prefix, prefix[i - k])
                if prefix[i] - min_prefix >= 0:
                    return True
            return False

        while hi - lo > 1e-5:
            mid = (lo + hi) / 2
            if can(mid):
                lo = mid
            else:
                hi = mid
        return lo
