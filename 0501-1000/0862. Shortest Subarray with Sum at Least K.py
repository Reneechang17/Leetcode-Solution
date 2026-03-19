# Time:O(n), Space:O(n)

from collections import deque
from typing import List

class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        n = len(nums)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]

        dq = deque()
        ans = float('inf')

        for i in range(n + 1):
            while dq and prefix[i] - prefix[dq[0]] >= k:
                ans = min(ans, i - dq.popleft())
            
            while dq and prefix[i] <= prefix[dq[-1]]:
                dq.pop()
            
            dq.append(i)
        
        return ans if ans != float('inf') else -1
    