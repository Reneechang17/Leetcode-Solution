// Medium
// DFS
// O(n)
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-ii/

class Solution {
    // dfs -> 找pq節點
    private boolean foundP = false;
    private boolean foundQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = dfs(root, p, q);
        return (foundP && foundQ) ? lca : null;
    }

    private TreeNode dfs (TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);

        if (node == p) {
            foundP = true;
            return node;
        }

        if (node == q) {
            foundQ = true;
            return node;
        }

        if (left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }
}
