# Time:O(h), Space:O(h)

from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def splitBST(
        self, root: Optional[TreeNode], target: int
    ) -> List[Optional[TreeNode]]:
        if not root:
            return [None, None]

        if root.val <= target:
            left_tree, right_tree = self.splitBST(root.right, target)
            root.right = left_tree
            return [root, right_tree]
        else:
            left_tree, right_tree = self.splitBST(root.left, target)
            root.left = right_tree
            return [left_tree, root]
