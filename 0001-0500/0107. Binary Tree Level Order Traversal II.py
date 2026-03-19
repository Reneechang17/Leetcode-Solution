# Time:O(n), Space:O(n)

from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        res = []
        que = [root]

        while que:
            level = []
            next_que = []
            for node in que:
                level.append(node.val)
                if node.left:
                    next_que.append(node.left)
                if node.right:
                    next_que.append(node.right)
            res.append(level)
            que = next_que
        
        return res[::-1] # reverse
    