package codesignal;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
  int[] solution(int[] houses, int[] queries) {
    class UnionFind {
      private HashMap<Integer, Integer> map;
      public int[] res;

      public UnionFind(int[] houses, int[] queries) {
        int n = queries.length;
        HashSet<Integer> set = new HashSet<>();
        for (int house : houses) {
          set.add(house);
        }
        for (int house : queries) {
          set.remove(house);
        }

        map = new HashMap<>();
        int num = 0;
        res = new int[n];
        for (int house : set) {
          map.put(house, house);
          num += 1;
          if (map.containsKey(house - 1)) {
            num -= union(house, house - 1);
          }
          if (map.containsKey(house + 1)) {
            num -= union(house, house + 1);
          }
        }

        for (int i = n - 1; i >= 0; i--) {
          res[i] = num;
          num += 1;
          map.put(queries[i], queries[i]);
          int house = queries[i];
          if (map.containsKey(house - 1)) {
            num -= union(house, house - 1);
          }
          if (map.containsKey(house + 1)) {
            num -= union(house, house + 1);
          }
        }
      }

      public int find(int index) {
        if (map.get(index) != index) {
          int fa = find(map.get(index));
          map.put(index, fa);
        }
        return map.get(index);
      }

      public int union(int left, int right) {
        left = find(left);
        right = find(right);
        if (left == right) {
          return 0;
        } else {
          map.put(left, right);
          return 1;
        }
      }
    }
    UnionFind uf = new UnionFind(houses, queries);
    return uf.res;
  }
}

/**
 * 問題總結：一個動態的房屋分佈，一開始有一些房屋，這些房屋按照一個線性排列
 * 給定房屋的位置和一系列要被摧毀的房屋的位置，每次摧毀一個房屋，則其左右相鄰的房屋會連接在一起，要求返回每次摧毀一個房屋後，剩餘的獨立區域數量
 * 
 * 思路：這題用並查集會非常高效，在這個問題中，房屋的摧毀會影響房屋區域的連續性，使用並查集可以快速地合併相鄰的房屋區域並查詢當前的連續區域數量
 * 具體做法：
 * 1. 初始化：使用hashset來存儲所有房屋的位置，對於每個即將被摧毀的房屋，從hashset中刪除
 * 2. 初始化並查集，每個房屋最開始都是自己的父節點，遍歷所有剩餘的房屋，嘗試將每個房屋與其左右相鄰的房屋合併，如果合併成功，則區域數量減1
 * 3. 從最後一個查詢開始向前處理，因為我們要逆向模擬房屋摧毀的過程，實際上就是逐步添加房屋。在並查集中添加房屋，嘗試將新添加的房屋與其左右鄰居合併，更新區域數量
 * 
 * 時間複雜度：O(n+q)
 **/