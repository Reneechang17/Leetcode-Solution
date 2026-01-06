# Time:O(n), Space:O(h)

from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def boundaryOfBinaryTree(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        res = [root.val]
        if not root.left and not root.right:
            return res

        def left_boundary(node):
            if not node or (not node.left and not node.right):
                return
            res.append(node.val)
            if node.left:
                left_boundary(node.left)
            else:
                left_boundary(node.right)

        def leaves(node):
            if not node:
                return
            if not node.left and not node.right:
                res.append(node.val)
                return
            leaves(node.left)
            leaves(node.right)

        def right_boundary(node):
            if not node or (not node.left and not node.right):
                return
            if node.right:
                right_boundary(node.right)
            else:
                right_boundary(node.left)
            res.append(node.val)

        left_boundary(root.left)
        leaves(root)
        right_boundary(root.right)

        return res
