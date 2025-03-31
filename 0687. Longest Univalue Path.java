// Medium
// DFS
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/longest-univalue-path/

class Solution {
    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left), right = dfs(node.right);
        int leftLen = 0, rightLen = 0;

        if (node.left != null && node.left.val == node.val) {
            leftLen = left + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            rightLen = right + 1;
        }
        maxLength = Math.max(maxLength, leftLen + rightLen);
        return Math.max(leftLen, rightLen); // choose the longer path
    }
}
