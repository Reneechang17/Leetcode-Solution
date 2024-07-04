// Medium
// Tree, DFS， Backtracking
// O(n)
// https://leetcode.com/problems/path-sum-iii/

import java.util.HashMap;
import java.util.Map;

class Solution {
  private Map<Long, Integer> prefixSumCount = new HashMap<>();
  private int target;

  public int pathSum(TreeNode root, int targetSum) {
      prefixSumCount.put(0L, 1);
      this.target = targetSum;
      return dfs(root, 0);
  }
  private int dfs(TreeNode node, long currentSum) {
      if (node == null) {
          return 0;
      }
      currentSum += node.val;
      int pathCount = prefixSumCount.getOrDefault(currentSum - target, 0);

      prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
      
      pathCount += dfs(node.left, currentSum);
      pathCount += dfs(node.right, currentSum);

      prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
      
      return pathCount;
  }
}

/**
 * 這題還是路徑總和的題，給定一個二叉樹的根節點和一個整數targetSum，求二叉樹節點值之和等於targetSum的路徑的數量
 * 不同的是，不需要從根節點開始，也不需要在葉子節點結束，但是路徑方向必須向下的（也就是只能從父節點到子節點）
 * 
 * 可以用哈希表統計從根節點到當前節點的路徑上各個前綴和出現的次數
 * Note: 初始化前綴和為0的情況，這對於直接從根節點開始的路徑是必需的
 * 
 * dfs中：
 * 首先先判斷node是否為空
 * 再累加當前節點的值當當前的路徑總和中（currentSum）
 * 用哈希表查找當前總和與目標總和之差的數量，這個表示到目前節點為止，有多少種方式可以到達目標和
 * 更新哈希表，對當前總和進行計數
 * 再遞歸計算左右子節點，記得要對哈希表做回溯
 **/