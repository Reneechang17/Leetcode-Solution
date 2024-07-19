// Medium
// DFS
// O(N^2)
// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int countPairs(TreeNode root, int distance) {
      int[] count = new int[1];
      dfs(root, distance, count);
      return count[0];
  }
  public List<Integer> dfs(TreeNode node, int distance, int[] count) {
      List<Integer> distances = new ArrayList<>();
      if (node == null) return distances;
      if (node.left == null && node.right == null) {
          distances.add(1);
          return distances;
      }

      List<Integer> left = dfs(node.left, distance, count);
      List<Integer> right = dfs(node.right, distance, count);

      for (int l : left) {
          for (int r : right) {
              if (l + r <= distance) {
                  count[0]++;
              }
          }
      }

      for (int l : left) {
          if (l + 1 < distance) distances.add(l + 1);
      }

      for (int r : right) {
          if (r + 1 < distance) distances.add(r + 1);
      }
      return distances;
  }
}

/**
 * 找出一個二叉樹中的所有葉子節點對的數量，其中節點對的距離小於或是等於給定的整數distance
 * 
 * 題目有提到shortest path，但和最短距離沒什麼關係
 * 即然要找葉子節點，那就可以用DFS去找：
 * 1. 遞歸遍歷：對於每個節點，需要知道它的左右子樹中所有葉子節點到當前節點的距離
 * 2. 收集葉子的距離：遞歸過程中，對於每一個節點都返回一個列表，表示該節點下所有葉子到它的距離
 * 3. 計算符合條件的葉子節點對：對於當前節點的左子樹和右子樹的所有節點對，如果兩個葉子的距離小於等於distance，則這對節點是符合條件的
 **/