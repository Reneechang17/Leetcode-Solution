# Medium
# Math
# Time:O(k), Space:O(1)
# https://leetcode.cn/problems/smallest-integer-divisible-by-k/

class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        if k % 2 == 0 or k % 5 == 0:
            return -1
        
        remainder = 0
        for len in range(1, k + 1):
            remainder = (remainder * 10 + 1) % k
            if remainder == 0:
                return len
            
        return -1
    