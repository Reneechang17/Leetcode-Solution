from typing import *
from TreeNode import TreeNode

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.dfs(root, 0)
    
    def dfs(self, node: Optional[TreeNode], curSum: int) -> int:
        if not node:
            return 0
        
        curSum = curSum * 10 + node.val

        if not node.left and not node.right:
            return curSum
        
        left = self.dfs(node.left, curSum)
        right = self.dfs(node.right, curSum)
        return left + right
