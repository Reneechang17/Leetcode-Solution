# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def minimalKSum(self, nums: List[int], k: int) -> int:
        nums = sorted(set(nums))
        res = 0
        cur = 1

        for num in nums:
            gap = num - cur
            take = min(gap, k)

            res += take * (2 * cur + take - 1) // 2
            k -= take
            cur = num + 1

            if k == 0:
                return res

        res += k * (2 * cur + k - 1) // 2
        return res
    