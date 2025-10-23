from typing import Optional
from TreeNode import TreeNode

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        prefix_sum = {0: 1}
        return self.dfs(root, 0, targetSum, prefix_sum)
    
    def dfs(self, node: Optional[TreeNode], cur: int, target: int, prefix_sum: dict) -> int:
        # basecase
        if not node:
            return 0
        
        cur += node.val

        cnt = prefix_sum.get(cur - target, 0)
        prefix_sum[cur] = prefix_sum.get(cur, 0) + 1

        # process left and right subtree recursively
        cnt += self.dfs(node.left, cur, target, prefix_sum)
        cnt += self.dfs(node.right, cur, target, prefix_sum) 

        # backtracking
        prefix_sum[cur] -= 1

        return cnt
