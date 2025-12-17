# Time:O(logn), Space:O(logn)

from typing import *
# find the path from root to label node(return every parent node)
class Solution:
    def pathInZigZagTree(self, label: int) -> List[int]:
        # find which level the label is on
        level = 0
        while 2 ** (level + 1) - 1 < label:
            level += 1
        
        path = []

        while label >= 1:
            path.append(label)

            # range of current level
            level_start = 2 ** level
            level_end = 2 ** (level + 1) - 1
            flipped = level_start + level_end - label
            parent = flipped // 2
            label = parent
            level -= 1

        return path[::-1] # reverse
    