// Hard
// DFS, Greedy
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/jC7MId/

class Solution {
    // Use DFS to calculate max Pathsum for each node from its left/right
    // Greedy: ignore negative contributions, maintain the maxSum to record them

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);
        int curMax = node.val + left + right;
        maxSum = Math.max(maxSum, curMax);
        return node.val + Math.max(left, right); 
    }
}
