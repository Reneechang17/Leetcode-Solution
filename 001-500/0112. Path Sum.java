// Easy
// DFS
// Time:O(n), Space:O(h)->h is the height of the tree
// https://leetcode.cn/problems/path-sum/

class Solution {
    // we can use DFS to go through the tree and check 
    // everytime we dfs, can we minus the root.val from targetSum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        targetSum -= root.val;

        // if the root's left and right are null
        // check if target is minus to zero, if yes, we find a valid path
        if (root.left == null && root.right == null) return targetSum == 0;

        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) return true;
        }

        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) return true;
        }
        return false;
    }
}
