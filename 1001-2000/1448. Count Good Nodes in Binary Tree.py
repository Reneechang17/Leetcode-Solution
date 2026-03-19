# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def goodNodes(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def dfs(node, max_val):
            if not node:
                return 
            
            if node.val >= max_val:
                self.ans += 1
            max_val = max(max_val, node.val)
            dfs(node.left, max_val)
            dfs(node.right, max_val)

        dfs(root, root.val) # init the max_val to root's val
        return self.ans
    