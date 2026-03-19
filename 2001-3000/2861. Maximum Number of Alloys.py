# Time: O(k × n × log M)
# Space: O(1)

from typing import List

class Solution:
    def maxNumberOfAlloys(self, n: int, k: int, budget: int, composition: List[List[int]], stock: List[int], cost: List[int]) -> int:
        left, right = 0, 10**9

        def can_make(target):
            min_cost = float('inf')

            for c in composition:
                total = 0
                for j in range(n):
                    need = c[j] * target
                    if need <= stock[j]:
                        continue
                    total += (need - stock[j]) * cost[j]
                min_cost = min(min_cost, total)
            
            return min_cost <= budget

        while left < right:
            mid = (left + right + 1) // 2 # 因为我们要找最大值，所以要向上取整避免死循环
            if can_make(mid):
                left = mid # mid可行，继续找
            else:
                right = mid - 1 # 不行，往小的找
        
        return left # 停在最后一个可行的值
    