# Time:O(n*k*logk), Space:O(1)

from typing import List

class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        n = len(nums)
        res = []

        for start in range(n - k + 1):
            freq = [0] * 51
            for i in range(start, start + k):
                freq[nums[i]] += 1

            elements = []
            for val in range(1, 51):
                if freq[val] > 0:
                    elements.append((val, freq[val]))

            elements.sort(key=lambda e: (-e[1], -e[0]))

            total = 0
            for i in range(min(x, len(elements))):
                val, count = elements[i]
                total += val * count

            res.append(total)

        return res        
