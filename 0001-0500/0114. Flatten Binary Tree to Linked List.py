# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        
        self.flatten(root.left)
        self.flatten(root.right)

        right = root.right

        if root.left:
            root.right = root.left
            root.left = None

            cur = root.right
            while cur.right:
                cur = cur.right
            cur.right = right
    