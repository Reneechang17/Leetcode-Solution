// Medium
// Tree
// O(n)
// https://leetcode.com/problems/validate-binary-search-tree/

class Solution {
  TreeNode max;
  public boolean isValidBST(TreeNode root) {
      if (root == null) return true;

      // 驗證左子樹
      boolean left = isValidBST(root.left);
      if (!left) return false;

      // 檢查當前是否小於前一個節點，如果小於，返回false
      if (max != null && root.val <= max.val) return false;
      max = root;

      // 驗證右子樹
      boolean right = isValidBST(root.right);
      if (!right) return false;
      return right;
  }
}

/**
 * 二叉搜索樹的特性：比中間節點小的都在左邊，大的都在右邊
 * 用中序遍歷（左中右），輸出的節點數值是有序的
 * 
 * 代碼：
 * basecase：如果這個樹是空樹，也是二叉搜索樹，返回true ->
 * 接著先驗證左子樹，如果左子樹不是，返回false ->
 * 檢查當前的節點是否小於前一個遍歷的節點，因為是有序的，所以如果比前一個小，那麼就是false ->
 * 最後驗證右子樹
 **/