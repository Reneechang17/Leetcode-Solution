# Time:O(n), Space:O(w)

from collections import deque
from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        res = []
        que = deque([root])

        while que:
            size = len(que)

            for i in range(size):
                node = que.popleft()

                if i == size - 1:
                    res.append(node.val)

                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)

        return res
