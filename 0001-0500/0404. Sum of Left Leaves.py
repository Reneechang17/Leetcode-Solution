# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        que = [(root, False)] # node, is_left
        total = 0

        while que:
            node, is_left = que.pop(0)
            if not node.left and not node.right and is_left:
                total += node.val
            if node.left:
                que.append((node.left, True))
            if node.right:
                que.append((node.right, False))
                
        return total
    