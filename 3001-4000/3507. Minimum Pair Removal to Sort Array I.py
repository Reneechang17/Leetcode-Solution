# Time:O(n³), Space:O(n)

from typing import List

class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        arr = nums[:]
        ops = 0

        while True:
            sorted_flag = True
            for i in range(len(arr) - 1):
                if arr[i] > arr[i + 1]:
                    sorted_flag = False
                    break
            if sorted_flag:
                return ops
            
            min_sum = float('inf')
            min_idx = -1

            for i in range(len(arr) - 1):
                s = arr[i] + arr[i + 1]
                if s < min_sum:
                    min_sum = s
                    min_idx = i
            
            arr[min_idx] = min_sum
            arr.pop(min_idx + 1)
            ops += 1
    