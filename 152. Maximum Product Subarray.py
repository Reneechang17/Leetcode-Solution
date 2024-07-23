# Medium
# Array, DP
# O(n)
# https://leetcode.com/problems/maximum-product-subarray/

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = f = g = nums[0]
        for x in nums[1:]:
            ff, gg = f, g
            f = max(x, ff * x, gg * x)
            g = min(x, ff * x, gg * x)
            ans = max(ans, f)
        return ans

# 乘積最大子數組：給定一個數組nums，找出數組中乘積最大的非空連續子數組（至少包含一個數字），並返回該子數組所對應的乘積

# 這題需要注意負數和負數相乘為正數，所以不只是追蹤乘積最大子數組的乘積，也要追蹤乘積最小子數組的乘積，因為他之後有可能和某個負數相乘成為最大乘積
