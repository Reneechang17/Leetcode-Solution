# Time:O(logn), Space:O(1)

from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findFirst():
            left, right = 0, len(nums) - 1
            res = -1

            while left <= right:
                mid = left + (right - left) // 2

                if nums[mid] == target:
                    res = mid
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1

            return res

        def findLast():
            left, right = 0, len(nums) - 1
            res = -1

            while left <= right:
                mid = left + (right - left) // 2

                if nums[mid] == target:
                    res = mid
                    left = mid + 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1

            return res

        return [findFirst(), findLast()]
    