// Medium
// DFS
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/count-univalue-subtrees/

class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }
    private boolean dfs(TreeNode node) {
        if (node == null) return true;

        // check left and right subtrees
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        if (!left || !right) return false;
        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;
        
        count++;
        return true;
    }
}
