// Medium
// DFS
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/maximum-product-of-splitted-binary-tree/

class Solution {
  // DFS to calculate the totalSum of tree, and calculate the subtreeSum
  //  so the remain part is totalSum-subtreeSum, then calculate and update  
  //  the max product= subtreeSum * (totalSum - subtreeSum)
  private long maxSum = 0;
  private long totalSum = 0;

  public int maxProduct(TreeNode root) {
      totalSum = getTotal(root); 
      getTotal(root); // get subtreeSum
      return (int)(maxSum % (1_000_000_007)); // get mod
  }
  private long getTotal(TreeNode root) {
      if (root == null) return 0;
      long leftSum = getTotal(root.left);
      long rightSum = getTotal(root.right);
      long subtreeSum = root.val + leftSum + rightSum;

      // calculate and update the maxSum
      if (totalSum != 0) {
          maxSum = Math.max(maxSum, subtreeSum * (totalSum - subtreeSum));
      }
      return subtreeSum;
  }
}
