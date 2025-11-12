from typing import *
from TreeNode import TreeNode

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max_sum = float('-inf')
        self.maxGain(root)
        return self.max_sum
    
    def maxGain(self, node: Optional[TreeNode]) -> int:
        if not node:
            return 0
        
        left = max(self.maxGain(node.left), 0)
        right = max(self.maxGain(node.right), 0)
        
        self.max_sum = max(self.max_sum, node.val + left + right)

        return node.val + max(left, right)
