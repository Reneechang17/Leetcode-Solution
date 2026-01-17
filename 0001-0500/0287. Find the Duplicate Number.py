from typing import List

# Time:O(nlogn), Space:O(1)
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        left, right = 1, len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            # count <= mid
            count = 0
            for num in nums:
                if num <= mid:
                    count += 1

            # if count > mid, dup in [left, mid]
            if count > mid:
                right = mid
            else:
                left = mid + 1

        return left

# Time:O(n), Space:O(1)
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # Can use two pointers to find the cycle entry
        slow = nums[0]
        fast = nums[0]

        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break

        slow = nums[0]
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]

        return slow
