// Medium
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/sum-root-to-leaf-numbers/

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int curSum) {
        if (node == null)
            return 0;
        
        curSum = curSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return curSum;
        }

        int leftSum = dfs(node.left, curSum);
        int rightSum = dfs(node.right, curSum);
        return leftSum + rightSum;
    }
}
