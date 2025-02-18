// Medium
// Union Find, Hash Set
// Time:O(n), Space:O(n)
// hhttps://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/

import java.util.*;
class Solution {
  public int removeStones(int[][] stones) {
      int[] father = new int[stones.length];
      // initialize
      for (int i = 0; i < stones.length; i++) {
          father[i] = i;
      }

      // union
      for (int i = 0; i < stones.length; i++) {
          for (int j = i + 1; j < stones.length; j++) {
              int x1 = stones[i][0];
              int y1 = stones[i][1];
              int x2 = stones[j][0];
              int y2 = stones[j][1];
              if (x1 == x2 || y1 == y2) {
                  union(father, i, j);
              }
          }
      }
      // 计算连通分量个数，用set去重
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < father.length; i++) {
          set.add(findFather(father, i));
      }
      // 我们要找的是所有石头数-连通分量个数
      return stones.length - set.size();
  }
  // 合并连通分量
  public void union(int[] father, int x, int y) {
      int xFather = findFather(father, x);
      int yFather = findFather(father, y);
      if (xFather != yFather) {
          father[xFather] = yFather;
      }
  }
  // 找上级
  public int findFather(int[] father, int x) {
      while (father[x] != x) {
          father[x] = father[father[x]];
          x = father[x];
      }
      return x;
  }
}
