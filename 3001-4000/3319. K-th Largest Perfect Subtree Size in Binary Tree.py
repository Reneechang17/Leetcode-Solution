# Time:O(nlogn), Space:O(n)

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def kthLargestPerfectSubtree(self, root: Optional[TreeNode], k: int) -> int:
        sizes = []

        def dfs(node):
            if not node:
                return 0, True

            left_height, left_perfect = dfs(node.left)
            right_height, right_perfect = dfs(node.right)

            if left_perfect and right_perfect and left_height == right_height:
                height = left_height + 1
                size = (2**height) - 1
                sizes.append(size)
                return height, True

            return 0, False

        dfs(root)

        if len(sizes) < k:
            return -1

        sizes.sort(reverse=True)
        return sizes[k - 1]
