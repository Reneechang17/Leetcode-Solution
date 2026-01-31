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
        # col -> (row, value)
        col_map = defaultdict(list)

        def dfs(node, col, row):
            if not node:
                return
            
            col_map[col].append((row, node.val))
            dfs(node.left, col - 1, row + 1)
            dfs(node.right, col + 1, row + 1)

        dfs(root, 0, 0)

        res = []
        for col in sorted(col_map.keys()):
            nodes = col_map[col]
            # sort by row, then val
            nodes.sort(key=lambda x: (x[0], x[1]))
            res.append([val for _, val in nodes])
        
        return res
    