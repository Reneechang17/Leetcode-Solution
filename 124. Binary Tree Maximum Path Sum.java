// Medium
// DFS, Greedy
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/binary-tree-maximum-path-sum/

class Solution {
    // Use DFS to calculate the max pathsum for each node from its left and right
    // But we can ignore the negative contributions, and maintain the maxSum to record it
    // Return max gain that this node can provide to its parent
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    public int maxGain(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int curMax = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, curMax);
        // Return max Gain to parent node
        return node.val + Math.max(leftGain, rightGain);
    }
}
