# Hard
# Math...?
# Time:O(logmax(tx,ty)), Space:O(1)
# https://leetcode.cn/problems/reaching-points/

# If we do straighforward way, for each(x, y) -> (x+y, y) or (x, x+y), if (tx, ty) is big -> goin crazy
# And we also don't know which one should we choose, use BFS/BFS go all is ....cost......

# So for this question we can have reverse thinking: for each (tx, ty)
# if tx > ty -> prev must be (tx-ty, ty); otherwise must be (tx, ty-tx)

# (1, 3) → (4, 3) → (7, 3) → ... → (100, 3) -> need 33 steps
# reverse with MOD (100, 3) → 100 % 3 = 1 → (1, 3) -> need 1 step only

class Solution:
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        while sx < tx != ty > sy:
            if tx > ty:
                tx %= ty
            else:
                ty %= tx
        
        if tx == sx and ty == sy:
            return True
        elif tx == sx:
            return ty > sy and (ty - sy) % tx == 0
        elif ty == sy:
            return tx > sx and (tx - sx) % ty == 0
        else:
            return False
     