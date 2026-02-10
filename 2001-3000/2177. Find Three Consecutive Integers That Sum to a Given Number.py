# Time:O(1), Space:O(1)

from typing import List

class Solution:
    def sumOfThree(self, num: int) -> List[int]:
        # x+(x+1)+(x+2)=num -> 3x+3=num -> x=(num-3)/3
        if (num - 3) % 3 == 0:
            x = (num - 3) // 3
            return [x, x + 1, x + 2]
        
        return []
    