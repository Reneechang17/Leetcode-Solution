from typing import Optional
from TreeNode import TreeNode

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        
        targetSum -= root.val

        # If touch leaf => check if targetSum = 0, which means we find the path
        if not root.left and not root.right:
            return targetSum == 0
        
        return self.hasPathSum(root.left, targetSum) or self.hasPathSum(root.right, targetSum)
        