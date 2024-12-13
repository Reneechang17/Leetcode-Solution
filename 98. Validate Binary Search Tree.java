// Medium
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/validate-binary-search-tree/

class Solution {
    // Use inorder traversal to check if the tree is a valid BST
    // Maintain a prev node to compare with the current node
    // If any node's value is not greater than the previous node's value, return false
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    private boolean inorder(TreeNode node) {
        if (node == null) return true;
        // check left subtree
        boolean left = inorder(node.left);
        if (!left) return false;
        // check cur node value with prev
        if (prev != null && node.val <= prev.val) return false;
        prev = node;
        // check right subtree
        return inorder(node.right);
    }
}
