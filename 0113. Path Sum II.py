from typing import *
from TreeNode import TreeNode

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        path = []
        self.dfs(root, targetSum, path, res)
        return res
    
    def dfs(self, node: Optional[TreeNode], targetSum: int, path: List[int], res: List[List[int]]) -> None:
        # base
        if not node:
            return
        
        # add cur node' val
        path.append(node.val)
        targetSum -= node.val

        # Check if reach the leaf and target = 0
        if not node.left and not node.right and targetSum == 0:
            res.append(list(path)) # need to copy!
        
        self.dfs(node.left, targetSum, path, res)
        self.dfs(node.right, targetSum, path, res)

        path.pop() # backtracking
        