# Time:O(n + m log n)
# Space:O(n)

from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def closestNodes(self, root: Optional[TreeNode], queries: List[int]) -> List[List[int]]:
        arr = []

        def inorder(node):
            if not node:
                return
            inorder(node.left)
            arr.append(node.val)
            inorder(node.right)
        
        inorder(root)

        ans = []
        for q in queries:
            lo, hi = 0, len(arr)
            while lo < hi:
                mid = (lo + hi) // 2
                if arr[mid] >= q:
                    hi = mid
                else:
                    lo = mid + 1
            min_val = arr[lo] if lo < len(arr) else -1

            lo, hi = 0, len(arr)
            while lo < hi:
                mid = (lo + hi) // 2
                if arr[mid] <= q:
                    lo = mid + 1
                else:
                    hi = mid
            max_val = arr[lo - 1] if lo > 0 else -1

            ans.append([max_val, min_val])
        
        return ans
    