# Time:O(n), Space:O(1)

class Solution:
    def countHousePlacements(self, n: int) -> int:
        # similar to house robber
        MOD = 10**9 + 7

        if n == 1:
            return 4 # 00,01,10,11
        
        prev2 = 1 # nothing
        prev1 = 2 # place or don't place

        for i in range(2, n + 1):
            cur = (prev1 + prev2) % MOD
            prev2 = prev1
            prev1 = cur
        
        one_side = prev1
        
        return (one_side * one_side) % MOD
    