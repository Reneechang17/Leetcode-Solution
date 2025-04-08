// Medium
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/validate-binary-search-tree/

class Solution {
    // Use Inorder traversal, and maintain prev node to compare with cur node
    // If any node's value is not greater than prev's value, return false

    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;
        boolean left = inorder(node.left);
        if (!left) return false;
        if (prev != null && node.val <= prev.val) return false;
        prev = node;
        return inorder(node.right);
    }
}
