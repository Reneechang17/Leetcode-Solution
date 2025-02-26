// Medium
// Recursion
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/count-univalue-subtrees/

class Solution {
    // if all node's val are same in a subtree -> this is unival subtree
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return count;
    }
    private boolean isUnival(TreeNode node) {
        if (node == null) return true;
        // recursively check left and right subtree
        boolean left = isUnival(node.left);
        boolean right = isUnival(node.right);
        if (!left || !right) return false;

        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;

        count++;
        return true;
    }
}
