# Time:O(n), Space:O(n)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        que = [root]
        level = 0

        while que:
            if level % 2 == 1:
                vals = [node.val for node in que]
                vals.reverse() # reverse
                for i, node in enumerate(que):
                    node.val = vals[i]
            
            next_que = []
            for node in que:
                if node.left:
                    next_que.append(node.left)
                if node.right:
                    next_que.append(node.right)
            que = next_que
            level += 1
        
        return root
    