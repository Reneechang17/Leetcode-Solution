# Time:O(n), Space:O(n+m)

from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        rem_set = set(to_delete)
        res = []

        def dfs(node):
            if not node:
                return None
            
            node.left = dfs(node.left)
            node.right = dfs(node.right)

            if node.val in rem_set:
                # it's childen(s) become the new root
                if node.left:
                    res.append(node.left)
                if node.right:
                    res.append(node.right)
                return None # means deleted
            
            return node

        root = dfs(root)
        if root:
            res.append(root)
        
        return res
    