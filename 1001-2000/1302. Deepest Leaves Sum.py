# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        self.max_depth = 0
        self.total = 0

        def dfs(node, depth):
            if not node:
                return 

            if not node.left and not node.right:
                if depth > self.max_depth:
                    self.max_depth = depth
                    self.total = node.val
                elif depth == self.max_depth:
                    self.total += node.val
            else:
                dfs(node.left, depth + 1)
                dfs(node.right, depth + 1)

        dfs(root, 0)
        return self.total
    