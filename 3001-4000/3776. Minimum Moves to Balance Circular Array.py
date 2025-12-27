# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def minMoves(self, balance: List[int]) -> int:
        if sum(balance) < 0:
            return -1
        
        n = len(balance)

        neg_idx = -1
        for i in range(n):
            if balance[i] < 0:
                neg_idx = i
                break
        if neg_idx == -1:
            return 0
        
        need = -balance[neg_idx]
        ans = 0

        dis = 1
        while need > 0:
            left_idx = (neg_idx - dis) % n
            right_idx = (neg_idx + dis) % n
            s = balance[left_idx] + balance[right_idx]

            if s >= need:
                ans += need * dis
                return ans
            ans += s * dis
            need -= s
            dis += 1
        
        return ans
    