// Medium
// Recursion
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/

class Solution {
    // 3 possible: 1. p in left & q in right 2.p in right & q in left 3. node itself
    // Start from root and recursion to check if left and right has p or q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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