# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        def merge_sort(left, right):
            if left >= right:
                return 0

            mid = (left + right) // 2
            count = merge_sort(left, mid) + merge_sort(mid + 1, right)

            j = mid + 1
            for i in range(left, mid + 1):
                while j <= right and nums[i] > 2 * nums[j]:
                    j += 1
                count += j - (mid + 1)

            tmp = []
            i, j = left, mid + 1
            while i <= mid and j <= right:
                if nums[i] <= nums[j]:
                    tmp.append(nums[i])
                    i += 1
                else:
                    tmp.append(nums[j])
                    j += 1

            tmp.extend(nums[i : mid + 1])
            tmp.extend(nums[j : right + 1])
            nums[left : right + 1] = tmp

            return count

        return merge_sort(0, len(nums) - 1)
