# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        # prefix[i]-prefix[j] in [lower, upper]
        n = len(nums)
        prefix = [0]
        for num in nums:
            prefix.append(prefix[-1] + num)

        def merge_sort(left, right):
            if left >= right:
                return 0

            mid = (left + right) // 2
            count = merge_sort(left, mid) + merge_sort(mid + 1, right)

            j = k = mid + 1
            for i in range(left, mid + 1):
                while j <= right and prefix[j] - prefix[i] < lower:
                    j += 1
                while k <= right and prefix[k] - prefix[i] <= upper:
                    k += 1
                count += k - j

            tmp = []
            i, j = left, mid + 1
            while i <= mid and j <= right:
                if prefix[i] <= prefix[j]:
                    tmp.append(prefix[i])
                    i += 1
                else:
                    tmp.append(prefix[j])
                    j += 1

            tmp.extend(prefix[i : mid + 1])
            tmp.extend(prefix[j : right + 1])
            prefix[left : right + 1] = tmp

            return count

        return merge_sort(0, n)
    