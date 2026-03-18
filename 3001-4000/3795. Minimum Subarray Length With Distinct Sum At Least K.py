# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def minLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        left = 0
        freq = {}
        num_sum = 0
        ans = n + 1

        for right in range(n):
            x = nums[right]
            if x not in freq or freq[x] == 0:
                num_sum += x
                freq[x] = 1
            else:
                freq[x] += 1
            
            while num_sum >= k:
                ans = min(ans, right - left + 1)
                left_val = nums[left]
                freq[left_val] -= 1
                if freq[left_val] == 0:
                    num_sum -= left_val
                left += 1
        
        return ans if ans <= n else -1
    