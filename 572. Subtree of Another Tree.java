// Easy
// Tree
// O(N)
// Similar: 100
// https://leetcode.com/problems/subtree-of-another-tree/

class Solution {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null)
      return false;
    if (isSame(root, subRoot))
      return true;
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  private boolean isSame(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null)
      return true;
    if (root == null || subRoot == null)
      return false;
    if (root.val != subRoot.val)
      return false;

    return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
  }
}

/**
 * 這題要看subRoot是不是Root的子樹
 * 作法和100類似
 * 但是在isSubtree方法中，我們需要先用isSame輔助方法判斷當前的root和subRoot是否same，如果不相同的話，再用分別遞歸判斷root的左子樹和右子樹和subRoot是否相等
 * 
 * isSame方法和100題的比較方法類似就不多述了
 **/