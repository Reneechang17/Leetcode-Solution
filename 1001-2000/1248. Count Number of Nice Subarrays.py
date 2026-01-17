# Time:O(n), Space:O(n)

from collections import defaultdict
from typing import List

class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        # prefix_odd_cnt[j] - prefix_even_cnt[i] = k
        # => prefix_even_cnt[i] = prefix_odd_cnt[j] - k
        count = defaultdict(int)
        count[0] = 1

        cur = 0
        res = 0

        for num in nums:
            # odd +1, even +0
            cur += num % 2
            res += count[cur - k]
            count[cur] += 1

        return res
