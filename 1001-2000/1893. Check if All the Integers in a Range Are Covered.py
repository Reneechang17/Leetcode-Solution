# Time:O(n*m), Space:O(m)

from typing import List

class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        covered = set()

        for start, end in ranges:
            for num in range(max(start, left), min(end, right) + 1):
                covered.add(num)
        
        return len(covered) == right - left + 1

# Time:O(1), Space:O(1)
class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        diff = [0] * 52

        # mark interval start and end
        for start, end in ranges:
            diff[start] += 1
            diff[end + 1] -= 1

        coverage = 0
        for i in range(1, 52):
            coverage += diff[i]
            if left <= i <= right and coverage == 0:
                return False
        return True
    