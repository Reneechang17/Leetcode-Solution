# base lc 198: https://leetcode.cn/problems/house-robber/
# follow-up1: circle, lc 213: https://leetcode.cn/problems/house-robber-ii/


from typing import *

# Question 1: lc 198
# two options: rob cur(dp[i-2] + nums[i]) or not(keep dp[i - 1])
# Time:O(n), Space:O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        # base
        if not nums:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        prev2 = nums[0]
        prev1 = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            cur = max(prev1, prev2 + nums[i])
            prev2 = prev1
            prev1 = cur
        
        return prev1  # last one dp[n-1]  
    
# Question 2: lc 213
class Solution2:
    def rob(self, nums: List[int]) -> int:
        # base
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)
        
        def helper(arr):
            prev2, prev1 = 0, 0
            for x in arr:
                cur = max(prev1, prev2 + x)
                prev2, prev1 = prev1, cur
            return prev1
        
        c1 = helper(nums[:-1])
        c2 = helper(nums[1:])
        return max(c1, c2)
    
# Question 3: can't rob any in k's houses

class Solution3:
    def rob_k_group(self, nums: List[int], k: int) -> int:
        n = len(nums)
        if n == 0:
            return 0
        if n <= k:
            return max(nums)
        
        dp = [0] * n
        dp[0] = nums[0]

        for i in range(1, n):
            # don't rob current
            dp[i] = dp[i - 1]

            # rob current, but make sure have k+1 distances
            prev = i - k - 1
            if prev >= 0:
                dp[i] = max(dp[i], dp[prev] + nums[i])
            else:
                dp[i] = max(dp[i], nums[i])
        
        return dp[-1]
    