# Time:O(n), Space:O(w)

from typing import *
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
        que = deque([root])
        level = 0

        while que:
            size = len(que)
            prev = None

            for _ in range(size):
                node = que.popleft()
                val = node.val

                if level % 2 == 0:
                    if val % 2 == 0:
                        return False
                    if prev is not None and val <= prev:
                        return False
                else:
                    if val % 2 != 0:
                        return False
                    if prev is not None and val >= prev:
                        return False
                prev = val

                # add child to que
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
            level += 1
            
        return True
    