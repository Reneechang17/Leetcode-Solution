// Easy
// DFS
// O(n)
// https://leetcode.cn/problems/diameter-of-binary-tree/

class Solution {
    // 找二叉樹中任意兩個節點之間路徑長度的最大值，也就是找直徑
    // 不一定要通過根節點，可以通過任意節點
    // DFS -> 找左右子樹高度的和

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        // 最大直徑：左右子樹高度的和
        max = Math.max(max, leftHeight + rightHeight);

        // 返回當前節點的高度(左右中較大的+1 加上當前節點)
        return Math.max(leftHeight, rightHeight) + 1;
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
