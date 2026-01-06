# Time:O(n + L log L), Space:O(n)

from collections import deque
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return -1

        que = deque([root])
        level_sums = []

        while que:
            level_sum = 0
            size = len(que)

            for _ in range(size):
                node = que.popleft()
                level_sum += node.val
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)

            level_sums.append(level_sum)

        if len(level_sums) < k:
            return -1

        level_sums.sort(reverse=True)
        return level_sums[k - 1]
    