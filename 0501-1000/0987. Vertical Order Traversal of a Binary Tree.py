# Time:O(nlogn), Space:O(n)

from typing import List, Optional
from collections import defaultdict

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        # columns[col]=[(row, val), ...]
        columns = defaultdict(list)

        def dfs(node, row, col):
            if not node:
                return

            columns[col].append((row, node.val))
            dfs(node.left, row + 1, col - 1)
            dfs(node.right, row + 1, col + 1)
        
        dfs(root, 0, 0)
        
        res = []

        # sort by col
        for col in sorted(columns.keys()):
            # sort by (row, val)
            col_node = sorted(columns[col])
            res.append([val for _, val in col_node])
        return res
    