from typing import List

class RangeFreqQuery:

    def __init__(self, arr: List[int]):
        self.pos = {}
        for i, num in enumerate(arr):
            if num not in self.pos:
                self.pos[num] = []
            self.pos[num].append(i)

    def query(self, left: int, right: int, value: int) -> int:
        if value not in self.pos:
            return 0
        
        indices = self.pos[value]

        # find first >= left（左边界）
        lo, hi = 0, len(indices) - 1
        left_pos = len(indices)
        while lo <= hi:
            mid = (lo + hi) // 2
            if indices[mid] >= left:
                left_pos = mid
                hi = mid - 1
            else:
                lo = mid + 1
        
        if left_pos == len(indices):
            return 0

        # find last <= right (右边界)
        lo, hi = left_pos, len(indices) - 1
        right_pos = -1
        while lo <= hi:
            mid = (lo + hi) // 2
            if indices[mid] <= right:
                right_pos = mid
                lo = mid + 1
            else:
                hi = mid - 1
        
        if right_pos == -1:
            return 0
        
        return right_pos - left_pos + 1
    