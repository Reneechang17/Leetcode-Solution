// Medium
// Recursion
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/

class Solution {
    // three possible situation: 1. p in left and q in right 2.p in right and q in left
    // 3. node itself
    // start from root and recursion to check if left and right has p or q
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
