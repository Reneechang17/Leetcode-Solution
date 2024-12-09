// Medium
// Two Pointers
// Time:O(m+n), Space:O(m+n)
// https://leetcode.cn/problems/interval-list-intersections/

import java.util.*;

class Solution {
  // 用两个指针i和j分别遍历firstList和secondList
  // 交集的起始为max(firstList[i][0], secondList[j][0])
  // 交集的结束为min(firstList[i][1], secondList[j][1])
  // 如果交集的起始时间<=结束时间, 则表示存在交集
  // 移动指针：谁的结束时间早，就移动那个指针，因为较早结束的区间不可能再与另一个区间有交集
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
      List<int[]> res = new ArrayList<>();
      int i = 0, j = 0;
      while (i < firstList.length && j < secondList.length) {
          int start = Math.max(firstList[i][0], secondList[j][0]);
          int end = Math.min(firstList[i][1], secondList[j][1]);
          if (start <= end) {
              res.add(new int[]{start, end});
          }
          if (firstList[i][1] < secondList[j][1]) {
              i++;
          } else {
              j++;
          }
      }
      return res.toArray(new int[res.size()][]);
  }
}
