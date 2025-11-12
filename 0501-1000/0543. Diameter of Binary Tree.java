// Easy
// DFS
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/diameter-of-binary-tree/

class Solution {
    // Use DFS to calculate left&right heights
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1; // height of cur node
    }
}

/**
       1
      / \
     2   3
    / \
   4   5
   
   對於葉子節點4&5:他們沒有左右子樹，所以左右高度都是0，所以4和5的高度分別是max(0,0)+1=1
   對於節點2：它的左子樹是4，右子樹是5，它們的高度都是1，所以2的高度是max(1,1)+1=2
   對於節點3：它沒有左右子樹，所以高度是max(0,0)+1=1
   對於根節點1：它的左子樹是2，右子樹是3，它們的高度分別是2和1，所以1的高度是max(2,1)+1=3
 **/
