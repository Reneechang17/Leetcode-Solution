# Time:O(n), Space:O(h)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def longestConsecutive(self, root: Optional[TreeNode]) -> int:
        self.max_len = 0

        def dfs(node, parent_val, cur_len):
            if not node:
                return 

            if parent_val is not None and node.val == parent_val + 1:
                cur_len += 1
            else:
                cur_len = 1
            
            self.max_len = max(self.max_len, cur_len)

            dfs(node.left, node.val, cur_len)
            dfs(node.right, node.val, cur_len)

        dfs(root, None, 0)
        return self.max_len
    