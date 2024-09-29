// Medium
// DFS, DP
// O(n)
// https://leetcode.cn/problems/binary-tree-maximum-path-sum/

class Solution {
  private int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
      dfs(root);
      return maxSum;
  }

  private int dfs(TreeNode node) {
      if (node == null) {
          return 0;
      }

      int left = Math.max(dfs(node.left), 0);
      int right = Math.max(dfs(node.right), 0);

      int curMax = node.val + left + right;
      maxSum = Math.max(maxSum, curMax);

      return node.val + Math.max(left, right);
  }
}

/**
 * 這題是要找出最大的路徑和，這個路徑和可以是任意的路徑，不一定是從root到leaf
 * 可以用dfs來遍歷所有節點，對於每個節點用DFS找node.val + left + right的最大值，負值就不要了
 * 但是最後只要返回node.val + max(left, right)就好了，因為要最大的路徑所以只要選一邊就好了
 * 這題算是用後序遍歷（左右中），從下往上，如果從上往下數值會被重複計算
 **/


// DP思想：對於每個節點，計算以當前節點為根的最大貢獻值
// 其實具體操作和DFS差不多

class Solution2 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int curMaxPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, curMaxPath);
        return node.val + Math.max(leftGain, rightGain);
    }
}