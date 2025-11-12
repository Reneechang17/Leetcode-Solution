// Hard
// DFS, Greedy
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/binary-tree-maximum-path-sum/

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null)
            return 0;
        
        // we don't consider negative 
        int leftGain = Math.max(maxGain(node.left), 0); 
        int rightGain = Math.max(maxGain(node.right), 0);
        int curMax = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, curMax);

        // return the max gain side
        return node.val + Math.max(leftGain, rightGain);
    }
}
