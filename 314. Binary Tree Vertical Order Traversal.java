// Medium
// Tree
// O(n)
// https://leetcode.com/problems/binary-tree-vertical-order-traversal/

import java.util.*;

class Solution {
  class Pair<T, U> {
      T first; 
      U second; 

      public Pair (T first, U second) {
          this.first = first;
          this.second = second;
      }
  }
  public List<List<Integer>> verticalOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) return res;

      Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
      que.offer(new Pair(root, 0));

      Map<Integer, List<Integer>> columnMap = new HashMap<>();

      while (!que.isEmpty()) {
          Pair<TreeNode, Integer> cur = que.poll();
          TreeNode curNode = cur.first;
          int column = cur.second;

          columnMap.putIfAbsent(column, new ArrayList<>());
          columnMap.get(column).add(curNode.val);

          if (curNode.left != null) que.offer(new Pair(curNode.left, column - 1));
          if (curNode.right != null) que.offer(new Pair(curNode.right, column + 1));
      }

      int minCol = Collections.min(columnMap.keySet());
      int maxCol = Collections.max(columnMap.keySet());

      for (int i = minCol; i <= maxCol; i++) {
          res.add(columnMap.get(i));
      }
      return res;
  }
}

/**
 * 這題要求從左到右垂直打印二叉樹的節點，可以將根節點想成列0處，那麼他的左子節點就在列-1，而右子點在列+1，對於左子節點的左子節點就是列-2，以此類推
 * 
 * 用一個輔助類Pair來存儲二叉樹的節點和其對應的列索引
 * 初始化，用List來裝結果；Queue用於BFS，同時存儲Pair（節點和列索引）；Map存儲每個列索引對應的節點值列表
 * 
 * BFS：
 * 1. 循環直到隊列為空
 * 2. 每次循環迭代中，從隊列中取出一個Pair對象（包含一個節點和該節點的列索引）
 * 3. 將節點的值添加到對應列的列表中
 * 4. 如果節點有左子節點，將左子節點和當前列索引-1加入隊列
 *    如果節點有右子節點，將右子節點和當前列索引+1加入隊列
 * 
 * 確定哈希表的最大和最小列索引，按照索引的順序由小到大遍歷，將每一列的節點值加到結果列表中
 **/