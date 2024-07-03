// Medium
// Tree, Hash Table
// O(n)
// https://leetcode.com/problems/most-frequent-subtree-sum/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  Map<Integer, Integer> sumCount;
  int maxCount;

  public int[] findFrequentTreeSum(TreeNode root) {
      maxCount = 0;
      sumCount = new HashMap<>();
      countSubtreeSums(root);

      List<Integer> maxSums = new ArrayList<>();
      for (int sum : sumCount.keySet()) {
          if (sumCount.get(sum) == maxCount) {
              maxSums.add(sum);
          }
      }
      // 轉回數組
      int[] res = new int[maxSums.size()];
      for (int i = 0; i < maxSums.size(); i++) {
          res[i] = maxSums.get(i);
      }
      return res;
  }

  private int countSubtreeSums (TreeNode node) {
      if (node == null) return 0;

      int leftSum = countSubtreeSums(node.left);
      int rightSum = countSubtreeSums(node.right);

      int curSum = node.val + leftSum + rightSum;

      int count = sumCount.getOrDefault(curSum, 0) + 1;
      sumCount.put(curSum, count);

      maxCount = Math.max(maxCount, count);
      return curSum;
  }
}

/**
 * 這題要求找出二叉樹種的子樹元素和最頻繁的和，如果多個和出現的次數相同，則返回所有的和
 * 
 * 解法：可以用遞歸計算子樹的和並使用哈希表跟蹤各個和出現的頻率
 * sumCount：哈希表紀錄每個子樹和出現的次數
 * maxCount：紀錄出現最頻繁的子樹和的次數
 * countSubtreeSums：遞歸方法計算每個節點為根的子樹和，並更新哈希表和最大次數
 **/