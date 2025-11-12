// Medium
// Array， Greedy, Sorting
// O(n^2)
// https://leetcode.cn/problems/queue-reconstruction-by-height/

import java.util.*;

class Solution {
  public int[][] reconstructQueue(int[][] people) {
      int n = people.length;
      Arrays.sort(people, (a, b) -> {
          if (a[0] == b[0]) return a[1] - b[1]; // 身高相同按照k升序，身高不同按照身高降序
          return b[0] - a[0];
      });

      LinkedList<int[]> que = new LinkedList<>();

      // p[1]是這個人的k值，表示當前人應該插入的具體位置
      for (int[] p : people) {
          que.add(p[1], p);
      }
      return que.toArray(new int[n][]);
  }
}

/**
 * 假設有一群亂序的人站成一個隊列，數組people表示這些人的一些屬性。每個people[i]=[hi,ki]，其hi表示第i個人的身高，且正好有ki的身高大於等於hi的人
 * 重新構造並返回數組，返回的隊列應該格式化為數組queue，其中queue[j] =[hj, kj]，是隊列中第j個人的屬性
 * 
 * 思路：這題有兩個維度需要考慮，分別是h和k，需要先確定一個，另一個可以透過插入來確定最終位置
 * 可以先按照身高排序，從大排到小，如果身高相同則升序
 * 
 * 局部：優先按照身高高的人的k來插入，插入操作後的人滿足隊列屬性
 * 全局：全部插完之後，整個隊列滿足要求
 **/