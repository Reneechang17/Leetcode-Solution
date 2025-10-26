# Easy
# Math
# Time:O(1), Space:O(1)
# https://leetcode.cn/problems/distribute-money-to-maximum-children/

# This problem need to discuss the edge case:D

class Solution:
    def distMoney(self, money: int, children: int) -> int:
        # Not enough money
        if money < children:
            return -1
        
        # Money too much
        if money > 8 * children:
            return children - 1
        
        money -= children

        # Check if distribute 7 money
        cnt = money // 7
        remain = money % 7

        # All childs get 8 money
        if cnt == children and remain == 0:
            return children
        
        # Last child get 3, so that he get 3+1 = 4, need to take one from another
        if cnt == children - 1 and remain == 3:
            return cnt - 1
        
        return min(cnt, children - 1)
