// Medium
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/validate-binary-search-tree/

class Solution {
    // use inorder to check if the left's value is smaller than the root.val
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;
        boolean left = inorder(node.left);
        if (!left) return false;

        if (prev != null && node.val <= prev.val) {
            return false;
        }
        prev = node;

        boolean right = inorder(node.right);
        if (!right) return false;
        return true;
    }
}
