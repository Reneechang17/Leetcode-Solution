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
        level = 1
        best_level = 1
        max_sum = float('-inf')

        while que:
            size = len(que)
            cur_sum = 0

            for _ in range(size):
                node = que.popleft()
                cur_sum += node.val

                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
            
            if cur_sum > max_sum:
                max_sum = cur_sum
                best_level = level
            
            level += 1
        
        return best_level
