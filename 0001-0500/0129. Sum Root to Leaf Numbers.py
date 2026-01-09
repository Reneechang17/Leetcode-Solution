# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, cur_num):
            if not node:
                return 0

            cur_num = cur_num * 10 + node.val

            if not node.left and not node.right:
                return cur_num

            return dfs(node.left, cur_num) + dfs(node.right, cur_num)

        return dfs(root, 0)
