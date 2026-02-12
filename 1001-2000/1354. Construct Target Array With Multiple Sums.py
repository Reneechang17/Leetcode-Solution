# ex. target = [9,3,5]

# init sum = 17, max = 9
# rest sum = 17 - 9 = 8
# prev(9) = 9 - 8 = 1 -> [1,3,5] -> sum = 9

# max = 5, rest sum = 9 - 5 = 4
# prev(5) = 5 - 4 = 1 -> [1,3,1] -> sum = 5

# max 3, rest sum = 5 - 3 = 2
# prev(3) = 3 - 2 = 1 -> [1,1,1] -> True

# Time:O(nlogn + klogn), Space:O(n)

import heapq
from typing import List

class Solution:
    def isPossible(self, target: List[int]) -> bool:
        total = sum(target)
        # max heap
        heap = [-x for x in target]
        heapq.heapify(heap)

        while True:
            max_val = -heapq.heappop(heap)

            if max_val == 1:
                return True
            
            rest = total - max_val

            if rest == 0 or max_val <= rest:
                return False
            
            prev = max_val % rest
            if prev == 0:
                prev = rest
            
            heapq.heappush(heap, -prev)
            total = rest + prev
            