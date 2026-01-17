# Time:O(n²), Space:O(n²)

from typing import List

class Solution:
    def countDistinct(self, nums: List[int], k: int, p: int) -> int:
        n = len(nums)
        arr = set()

        for i in range(n):
            count = 0
            subarr = []
            for j in range(i, n):
                if nums[j] % p == 0:
                    count += 1
                if count > k:
                    break
                subarr.append(nums[j])

                arr.add(tuple(subarr))

        return len(arr)
