// Medium
// Tree
// O(log N)
// https://leetcode.com/problems/insert-into-a-binary-search-tree/

class Solution {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null)
      return new TreeNode(val);

    TreeNode originRoot = root;
    TreeNode curRoot = root;

    while (root != null) {
      curRoot = root;
      if (root.val > val) {
        root = root.left;
      } else if (root.val < val) {
        root = root.right;
      }
    }
    if (curRoot.val > val) {
      curRoot.left = new TreeNode(val);
    } else {
      curRoot.right = new TreeNode(val);
    }
    return originRoot;
  }
}

/**
 * 在二叉搜索樹中插入值
 * 
 * 關鍵在於在哪個位置插入值？？
 * 可以用二叉搜索樹的特性來搜索（logN）
 * 注意需要保留原始的root，用一個curRoot來表示當前節點的父節點
 * 最後還是要返回以原始root為根節點的樹
 **/