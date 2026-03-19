# Time:O(n), Space:O(n)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        # calc depth
        depth = {}

        def get_depth(node):
            if not node:
                return 0

            d = 1 + max(get_depth(node.left), get_depth(node.right))
            depth[node] = d
            return d

        get_depth(root)

        # find lca for the deepest leaves
        def find_lca(node):
            if not node:
                return None
            
            left_depth = depth.get(node.left, 0)
            right_depth = depth.get(node.right, 0)

            if left_depth == right_depth:
                return node
            elif left_depth > right_depth:
                return find_lca(node.left)
            else:
                return find_lca(node.right)

        return find_lca(root)
    