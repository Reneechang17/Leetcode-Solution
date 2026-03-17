# Time:O(1), Space:O(n)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.values = []
        self.index = 0
        self._inorder(root)

    def _inorder(self, node):
        if not node:
            return
        self._inorder(node.left)
        self.values.append(node.val)
        self._inorder(node.right)

    def next(self) -> int:
        val = self.values[self.index]
        self.index += 1
        return val

    def hasNext(self) -> bool:
        return self.index < len(self.values)

# lazy iteration
# 不一次性存所有节点
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self._push_left(root)

    def _push_left(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        node = self.stack.pop()
        if node.right:
            self._push_left(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0
    