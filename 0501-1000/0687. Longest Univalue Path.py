# Time:O(n),Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        self.max_len = 0

        def dfs(node):
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            left_len = left + 1 if node.left and node.left.val == node.val else 0
            right_len = right + 1 if node.right and node.right.val == node.val else 0

            self.max_len = max(self.max_len, left_len + right_len)

            return max(left_len, right_len)

        dfs(root)
        return self.max_len
    