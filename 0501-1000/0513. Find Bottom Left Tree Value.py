# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        self.max_depth = -1
        self.ans = 0

        def dfs(node, depth):
            if not node:
                return 
            if depth > self.max_depth:
                self.max_depth = depth
                self.ans = node.val
            
            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)

        dfs(root, 0) # node, depth
        return self.ans
    