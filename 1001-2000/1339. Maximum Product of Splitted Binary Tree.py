# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        MOD = 10**9 + 7

        # calculate total
        def get_sum(node):
            if not node:
                return 0
            return node.val + get_sum(node.left) + get_sum(node.right)

        total = get_sum(root)
        max_prod = 0

        def dfs(node):
            nonlocal max_prod
            if not node:
                return 0

            sub_sum = node.val + dfs(node.left) + dfs(node.right)
            prod = sub_sum * (total - sub_sum)
            max_prod = max(max_prod, prod)

            return sub_sum

        dfs(root)
        return max_prod % MOD
    