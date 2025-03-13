// Medium
// DFS, BST
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/largest-bst-subtree/

class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        // if cur is a valid BST, return it node count
        if (isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return countNodes(root);
        }
        // or recursively check left/right subtree, and return max one
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    private boolean isValid(TreeNode root, long left, long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) return false;
        // recursively check left/right subtree
        return isValid(root.left, left, root.val) && isValid(root.right, root.val, right);
    }
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
