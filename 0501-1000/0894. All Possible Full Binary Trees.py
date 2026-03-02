# Time:O(2^n), Space:O(2^n)

from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def allPossibleFBT(self, n: int) -> List[Optional[TreeNode]]:
        if n % 2 == 0:
            return []
        
        memo = {}

        def build(n: int) -> List[Optional[TreeNode]]:
            if n in memo:
                return memo[n]
            
            if n == 1:
                return [TreeNode(0)]
            
            res = []
            for i in range(1, n - 1, 2):
                j = n - 1 - i
                left_trees = build(i)
                right_trees = build(j)
                for left in left_trees:
                    for right in right_trees:
                        root = TreeNode(0)
                        root.left = left
                        root.right = right
                        res.append(root)
            memo[n] = res
            return res

        return build(n)
    