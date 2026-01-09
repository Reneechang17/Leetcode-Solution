# Time:O(n), Space:O(n)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        prefix_sum = {0: 1}

        def dfs(node, cur_sum):
            if not node:
                return 0

            cur_sum += node.val
            count = 0

            if cur_sum - targetSum in prefix_sum:
                count = prefix_sum[cur_sum - targetSum]

            prefix_sum[cur_sum] = prefix_sum.get(cur_sum, 0) + 1

            count += dfs(node.left, cur_sum)
            count += dfs(node.right, cur_sum)

            prefix_sum[cur_sum] -= 1

            return count

        return dfs(root, 0)
