# Medium
# Simulation
# Time:O(n*d), Space:O(1) -> fixed size
# https://leetcode.cn/problems/next-greater-numerically-balanced-number/

# Emm I was wondering if dp or other ways, a little be surprised that we can just simulate...?

class Solution:
    def nextBeautifulNumber(self, n: int) -> int:
        # Check from next number
        num = n + 1

        while num <= 10000000:
            if self.is_balanced(num):
                return num
            num += 1
        return -1
    
    def is_balanced(self, num: int) -> bool:
        cnt = [0] * 10
        tmp = num
        
        while tmp > 0:
            cnt[tmp % 10] += 1
            tmp //= 10

        # Check each appear number
        for d in range(10):
            if cnt[d] > 0 and cnt[d] != d:
                return False
            
        return True
