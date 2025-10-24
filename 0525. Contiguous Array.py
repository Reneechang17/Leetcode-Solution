from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # {prefixsum, first appear index}
        prefix = {0: -1}

        prefix_sum = 0
        max_len = 0

        for i, num in enumerate(nums):
            # serve 0 as -1
            prefix_sum += 1 if num == 1 else -1

            if prefix_sum in prefix:
                len = i - prefix[prefix_sum]
                max_len = max(max_len, len)
            else:
                prefix[prefix_sum] = i;

        return max_len
    