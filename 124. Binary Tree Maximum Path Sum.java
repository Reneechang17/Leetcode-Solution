// Medium
// DFS, DP
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/binary-tree-maximum-path-sum/

class Solution {
    // 对于每个节点，计算以当前节点为根的最大贡献值
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        // 计算从左边和右边得到的，如果是负数直接不要了，所以比较的是得到的值和0
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int curMax = node.val + leftGain + rightGain;
        maxSum = Math.max(curMax, maxSum);
        return node.val + Math.max(leftGain, rightGain);
    }
}
