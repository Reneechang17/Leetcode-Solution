# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def sufficientSubset(self, root: Optional[TreeNode], limit: int) -> Optional[TreeNode]:

        def dfs(node, cur_sum): 
            if not node:
                return None
            
            cur_sum += node.val

            if not node.left and not node.right:
                return None if cur_sum < limit else node
            
            node.left = dfs(node.left, cur_sum)
            node.right = dfs(node.right, cur_sum)

            if not node.left and not node.right:
                return None
            
            return node

        return dfs(root, 0) # node, cur_sum
    