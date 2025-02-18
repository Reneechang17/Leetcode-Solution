// Medium
// DFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/boundary-of-binary-tree/

import java.util.*;
class Solution {
    // root -> leftmost -> bottom leaf -> rightmost
    List<Integer> res = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left); // left subtree leaves
        leaves(root.right); // right subtree leaves
        rightBoundary(root.right);
        return res;
    }
    private void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left != null) leftBoundary(root.left);
        else leftBoundary(root.right);
    }
    private void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
    private void rightBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right != null) rightBoundary(root.right);
        else rightBoundary(root.left);
        res.add(root.val); // after recursion then add it in reversed
    }
}
