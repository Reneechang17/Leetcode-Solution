# Time:O(n), Space:O(h)

from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []

        def backtracking(node, path, cur_sum):
            if not node:
                return

            path.append(node.val)
            cur_sum += node.val

            if not node.left and not node.right:
                if cur_sum == targetSum:
                    res.append(path[:])

            backtracking(node.left, path, cur_sum)
            backtracking(node.right, path, cur_sum)

            path.pop()

        backtracking(root, [], 0)
        return res
   