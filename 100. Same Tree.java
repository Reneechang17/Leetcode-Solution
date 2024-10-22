// Easy
// DFS
// O(n)
// Similar: 101
// https://leetcode.cn/problems/same-tree/

class Solution {
  //  可以用DFS來比較
  public boolean isSameTree(TreeNode p, TreeNode q) {
      return compare(p, q);
  }

  private boolean compare(TreeNode p, TreeNode q) {
      // 先檢查是否為空節點，再比較值
      if (p == null && q == null) {
          return true;
      }
      if (p == null || q == null) {
          return false;
      }

      if (p.val != q.val) {
          return false;
      }

      boolean compareLeft = compare(p.left, q.left);
      boolean compareRight = compare(p.right, q.right);
      return compareLeft && compareRight;
  }
}
