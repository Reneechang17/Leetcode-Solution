# Time:O(n),Space:O(h)

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(
        self, root: "TreeNode", p: "TreeNode", q: "TreeNode"
    ) -> "TreeNode":
        self.found_p = False
        self.found_q = False

        def dfs(node):
            if not node:
                return None

            if node == p:
                self.found_p = True
            if node == q:
                self.found_q = True

            left = dfs(node.left)
            right = dfs(node.right)

            if node == p or node == q:
                return node

            if left and right:
                return node

            return left if left else right

        lca = dfs(root)

        if self.found_p and self.found_q:
            return lca

        return None
