// Medium
// Tree
// O(n)
// Similar: 235
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 根據題目，有三種LCA的情況 1. 左子樹有p，右子樹有q 2. 左子樹有q，右子樹有p
        // 3. pq自己就是LCA
        // 用後序遍歷 -> left-right-root，從下往上找

        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }
}
