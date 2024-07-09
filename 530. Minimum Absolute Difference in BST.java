// Easy
// Tree, DFS
// O(n)
// https://leetcode.com/problems/minimum-absolute-difference-in-bst/

class Solution {
  int res = Integer.MAX_VALUE;
  TreeNode pre;

  public int getMinimumDifference(TreeNode root) {
    if (root == null)
      return 0;
    inorder(root);
    return res;
  }

  private void inorder(TreeNode root) {
    if (root == null)
      return;
    inorder(root.left);
    if (pre != null) {
      res = Math.min(res, root.val - pre.val);
    }
    pre = root;
    inorder(root.right);
  }
}

/**
 * 計算二叉搜索樹中的任一兩個節點差的絕對值最小值
 * 因為二叉搜索樹的值是有序的，所以我們可以看成在一個有序數組上求差的最小值
 * 用中序遍歷做DFS，以及res來不斷更新當前節點和前一個節點的差值的最小值
 **/
