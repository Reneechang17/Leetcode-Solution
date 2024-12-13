// Easy
// DFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/same-tree/

class Solution {
    // Compare two trees recursively using DFS
    // If both nodes are null, they are same
    // If one is null or values differ, they are not same
    // Recursively compare left and right subtrees
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }
    private boolean compare(TreeNode p, TreeNode q) {
        // check null conditions
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        // check node value
        if (p.val != q.val) return false;
        return compare(p.left, q.left) && compare(p.right, q.right);
    }
}
