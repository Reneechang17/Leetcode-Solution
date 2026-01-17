# Time:O(n), Space:O(w)

from typing import Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def addOneRow(
        self, root: Optional[TreeNode], val: int, depth: int
    ) -> Optional[TreeNode]:
        if depth == 1:
            new_root = TreeNode(val)
            new_root.left = root
            return new_root

        que = deque([(root, 1)])
        while que:
            node, cur_depth = que.popleft()
            if cur_depth == depth - 1:
                old_left, old_right = node.left, node.right

                node.left = TreeNode(val)
                node.right = TreeNode(val)

                node.left.left = old_left
                node.right.right = old_right
            else:
                if node.left:
                    que.append((node.left, cur_depth + 1))
                if node.right:
                    que.append((node.right, cur_depth + 1))

        return root

class Solution:
    def addOneRow(
        self, root: Optional[TreeNode], val: int, depth: int
    ) -> Optional[TreeNode]:
        if depth == 1:
            new_root = TreeNode(val)
            new_root.left = root
            return new_root

        def dfs(node, cur_depth):
            if not node:
                return

            if cur_depth == depth - 1:
                left_child = TreeNode(val)
                left_child.left = node.left
                node.left = left_child

                right_child = TreeNode(val)
                right_child.right = node.right
                node.right = right_child
            else:
                dfs(node.left, cur_depth + 1)
                dfs(node.right, cur_depth + 1)

        dfs(root, 1)
        return root
    