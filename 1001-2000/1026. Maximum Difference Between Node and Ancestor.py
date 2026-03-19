# Time:O(n), Space:O(n)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def dfs(node, cur_max, cur_min):
            if not node:
                return 
            
            cur_max = max(cur_max, node.val)
            cur_min = min(cur_min, node.val)

            self.ans = max(self.ans, abs(node.val - cur_max), abs(node.val - cur_min))

            dfs(node.left, cur_max, cur_min)
            dfs(node.right, cur_max, cur_min)
        
        dfs(root, root.val, root.val) # node, cur_max, cur_min
        return self.ans
    