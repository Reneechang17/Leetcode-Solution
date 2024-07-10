// Medium
// Tree
// O(N)
// Same: 538
// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

  class Solution {
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }
    public void reverseInorder(TreeNode root) {
        if (root == null) return;

        reverseInorder(root.right);
        sum += root.val;
        root.val = sum;
        reverseInorder(root.left);
    }
}

// 這題和538一模一樣