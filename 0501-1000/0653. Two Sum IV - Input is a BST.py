# Time:O(n), Space:O(n)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        vis = set()

        def dfs(node):
            if not node:
                return False
            if k - node.val in vis:
                return True
            vis.add(node.val)
            return dfs(node.left) or dfs(node.right)

        return dfs(root)
