# Time:O(n), Space:O(n)
from typing import *
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # BFS -> (node, parent, depth)
        que = deque([(root, None, 0)])

        # store info for x and y
        x_info = None
        y_info = None
        
        while que:
            node, parent, depth = que.popleft()
            
            if node.val == x:
                x_info = (parent, depth)
            if node.val == y:
                y_info = (parent, depth)
            
            if x_info and y_info:
                break
            
            if node.left:
                que.append((node.left, node, depth + 1))
            if node.right:
                que.append((node.right, node, depth + 1))
        return (x_info[1] == y_info[1] and
                x_info[0] != y_info[0])
    