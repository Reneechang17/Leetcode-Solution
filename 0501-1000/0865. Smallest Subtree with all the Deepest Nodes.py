# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def subtreeWithAllDeepest(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(node):
            if not node:
                return 0, None
            
            left_depth, left_root = dfs(node.left)
            right_depth, right_root = dfs(node.right)

            if left_depth == right_depth:
                return left_depth + 1, node
            
            if left_depth > right_depth:
                return left_depth + 1, left_root
            else:
                return right_depth + 1, right_root

        _, res = dfs(root)
        return res
     