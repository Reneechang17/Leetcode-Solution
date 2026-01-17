# Time:O(n), Space:O(n)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from collections import defaultdict, deque
from typing import List, Optional

class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        col_map = defaultdict(list)
        min_col = max_col = 0

        que = deque([(root, 0)])  # node, column

        while que:
            node, col = que.popleft()
            col_map[col].append(node.val)
            min_col = min(min_col, col)
            max_col = max(max_col, col)

            if node.left:
                que.append((node.left, col - 1))
            if node.right:
                que.append((node.right, col + 1))

        return [col_map[col] for col in range(min_col, max_col + 1)]
    