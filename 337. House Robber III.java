// Medium
// DP
// O(n)
// https://leetcode.com/problems/house-robber-iii/

class Solution {
  public int rob(TreeNode root) {
      int[] res = robAction(root);
      return Math.max(res[0], res[1]);
  }

  public int[] robAction(TreeNode root) {
      int[] res = new int[2];
      if (root == null) {
          return res;
      }

      int[] left = robAction(root.left);
      int[] right = robAction(root.right);

      // 如果不打劫當前節點，那麼其左右節點可以選擇打劫也可以選擇不打劫，選擇他們最大值相加
      res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
      res[1] = root.val + left[0] + right[0]; // 如果打劫當前節點，則其左右節點都不能打劫
      return res;
  }
}

/**
 * 打家劫舍，看最多能偷多少錢，不能偷相鄰的，但是這題是在二叉樹結構的房屋進行打家劫舍
 * 
 * 思路：
 * 對於每個節點，有兩種選擇
 * 1. 如果打劫這個節點，就不能打劫它的子節點
 * 2. 如果不打劫這個節點，那麼可以選擇是否打劫它的子節點
 * 
 * 對於每個節點，需要返回兩個值：當前節點沒有被打劫時的最大金額（res[0])、當前節點被打劫時的最大金額（res[1])
 **/