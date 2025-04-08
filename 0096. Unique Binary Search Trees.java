// Medium
// DP
// Time:O(n²),Space:O(n)
// https://leetcode.cn/problems/unique-binary-search-trees/

class Solution {
  public int numTrees(int n) {
      int[] dp = new int[n + 1];

      // empty tree or only one node in tree
      dp[0] = 1;
      dp[1] = 1;

      for (int i = 2; i <= n; i++) {
          for (int j = 1; j <= i; j++) {
              dp[i] += dp[j - 1] * dp[i - j];
          }
      }
      return dp[n];
  }
}

/**
* 这题看似可以用回溯，但直接生成所有可能的BST会非常耗时，实际上是一个DP问题，用数学的Catalan Number来解决
* dp[i]表示由i个节点组成的不同BST的个数，对于i个节点，可以选择1～i中任何一个节点作为根节点：
* 当选择j为根节点时(i<=j<=i)：
* 左子树由j-1个节点组成（值为1～j-1），右子树i-j个节点组成（值为j+1～i）
* => 这些子树的组合数为：dp[j-1]*dp[i-j]
*/
