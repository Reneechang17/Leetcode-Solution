// Hard
// Marh, Hash Table
// O(n^2)
// https://leetcode.cn/problems/max-points-on-a-line/

import java.util.*;

class Solution {
  public int maxPoints(int[][] points) {
      // 這題的本質是計算斜率的問題，可以通過斜率確定哪些點在同一條直線上
      // 斜率公式 -> dy/dx -> y2-y1 / x2-x1
      // 如果 dx == 0 -> 表示兩點是垂直，可以特殊處理
      // 如果 dy == 0 -> 表示兩點是水平
      // 可以通過化簡分數來確保兩點之間的斜率是可比的

      if (points.length <= 2) return points.length;

      int max = 0;

      // 遍歷每一個點
      for (int i = 0; i < points.length; i++) {
          Map<String, Integer> map = new HashMap<>(); // 存斜率的哈希表
          int duplicate = 1, curMax = 0;

          // 遍歷其他點
          for (int j = i + 1; j < points.length; j++) {
              int dx = points[j][0] - points[i][0];
              int dy = points[j][1] - points[i][1];

              // 判斷是否是重合的點
              if (dx == 0 && dy == 0) {
                  duplicate++;
                  continue;
              }

              // 計算斜率，化簡分數
              int gcd = gcd(dx, dy);
              dx /= gcd;
              dy /= gcd;

              // 為了統一斜率的表示，將斜率表示為字符串 dy/dx
              String slope = dy + "/" + dx;

              // 將斜率存入哈希表並且更新斜率出現的次數
              map.put(slope, map.getOrDefault(slope, 0) + 1);
              curMax = Math.max(curMax, map.get(slope));
          }
          // 更新最大點數，包含重合的點數
          max = Math.max(max, curMax + duplicate);
      }
      return max;
  }

  // 求兩個數的最大公約數 -> 使用歐幾里德算法
  private int gcd(int a, int b) {
      return b == 0 ? a : gcd(b, a % b);
  }
}
