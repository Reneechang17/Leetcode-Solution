// Easy
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/range-sum-of-bst/

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    private int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        if (node.val > low) {
            sum += dfs(node.left, low, high);
        }
        if (node.val < high) {
            sum += dfs(node.right, low, high);
        }
        return sum;
    }
}
