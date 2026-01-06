# Time:O(n), Space:O(w)

from collections import deque
from typing import Optional

class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: "Optional[Node]") -> "Optional[Node]":
        if not root:
            return None

        que = deque([root])

        while que:
            size = len(que)
            prev = None

            for i in range(size):
                node = que.popleft()

                if prev:
                    prev.next = node
                prev = node

                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)

        return root
