// Easy
// Tree
// O(N)
// Similar: 101
// https://leetcode.com/problems/symmetric-tree/

class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return compare(p, q);
  }

  private boolean compare(TreeNode p, TreeNode q) {
    if (p == null && q != null)
      return false;
    if (p != null && q == null)
      return false;
    if (p == null && q == null)
      return true;

    if (p.val != q.val)
      return false;
    boolean compareLeftside = compare(p.left, q.left);
    boolean compareRightside = compare(p.right, q.right);
    return compareLeftside && compareRightside;
  }
}

/**
 * 這題是比較兩個樹是不是一樣的
 * 解法和101基本一樣，唯一不同的是
 * 在比較左右子樹的左右孩子時：
 * 對稱二叉樹的外側孩子相同，內側孩子相同
 * 而相同的樹直接比較兩者的左孩子們和右孩子們是否相同即可
 **/