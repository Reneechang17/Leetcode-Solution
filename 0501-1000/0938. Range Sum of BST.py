# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.ans = 0

        def inorder(node):
            if not node:
                return
            
            inorder(node.left)
            if low <= node.val <= high:
                self.ans += node.val
            inorder(node.right)

        inorder(root)
        return self.ans
    