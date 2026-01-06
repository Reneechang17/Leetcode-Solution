# Time:O(n), Space:O(w)

from collections import deque
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        que = deque([root])
        max_sum = float("-inf")
        max_level = 0
        cur_level = 1

        while que:
            level_sum = 0
            size = len(que)

            for _ in range(size):
                node = que.popleft()
                level_sum += node.val
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)

            if level_sum > max_sum:
                max_sum = level_sum
                max_level = cur_level

            cur_level += 1

        return max_level
