// Easy
// Tree
// O(n)
// Similar: 100
// https://leetcode.cn/problems/symmetric-tree/

class Solution {
  public boolean isSymmetric(TreeNode root) {
      return compare(root.left, root.right);
  }

  private boolean compare(TreeNode left, TreeNode right) {
      // base case
      if (left == null && right != null) return false;
      if (left != null && right == null) return false;
      if (left == null && right == null) return true;
      if (left.val != right.val) return false;

      boolean compareOutside = compare(left.left, right.right);
      boolean compareInside = compare(left.right, right.left);
      return compareOutside && compareInside;
  }
}

/**
 * 檢查二叉樹是否對稱，建議看圖比較好分析
 * 這題相當於比較左右子樹是否一樣，所以compare方法傳入的是左右子樹
 * 首先有3個可以從圖中看出的base case：
 * 1 & 2 左右子樹任意一個為null，另一個不為null 則返回false
 * 3. 如果左右子樹都是null 則返回true
 * 確定好左右子樹是否存在的問題後，接著比較左右子樹的值是否相同
 * 再來比較他們的左右孩子，注意比較的是左子樹的左孩子應該和右子樹的右孩子相同
 * 而左子樹的右孩子則應該和右子樹的左孩子相同
 **/
