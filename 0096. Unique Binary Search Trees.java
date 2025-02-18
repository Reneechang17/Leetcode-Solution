// Medium
// DP, BST
// O(n^2)
// https://leetcode.com/problems/unique-binary-search-trees/

class Solution {
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    // i表示有幾個元素
    dp[0] = 1; // 空樹也是一種BST
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      // j表示可能的根節點
      for (int j = 1; j <= i; j++) {
        // j - 1表示左子樹的節點數，根節點是j，左子數都比j小
        // i - j表示右子樹的節點數，右子樹都比j大
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }
    return dp[n];
  }
}

/**
 * 不同的BST：簡單來說，求有幾種以1...n為節點組成的BST
 * 
 * 這題的核心在於，i表示構建BST的節點數，j表示根節點的值
 * 以及初始化，空樹也是一種BST，只有一個節點也是一顆BST
 * 
 * 對於每個j（根節點），dp[i]為左子樹節點數+右子樹節點數
 **/