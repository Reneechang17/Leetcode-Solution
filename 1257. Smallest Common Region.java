// Medium
// Hash Table
// O(N)
// https://leetcode.com/problems/smallest-common-region/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
  public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
      Map<String, String> parentMap = new HashMap<>();

      for (List<String> region : regions) {
        for (int i = 1; i < region.size(); i++) {
          parentMap.put(region.get(i), region.get(0));
        }
      }
      
      // 找從region1到根的路徑
      Set<String> path = new HashSet<>();
      while (region1 != null) {
          path.add(region1);
          region1 = parentMap.get(region1);
      }

      while (!path.contains(region2)) {
          region2 = parentMap.get(region2);
      }

      return region2;
  }
}

/**
 * 目標是找兩個區域的最小公共區域
 * 
 * 思路：可以先建立一個map，紀錄每一個區域是從哪一個更大的區域分出來的。
 * 接著從region1開始，一直往上找到他的頂層區域紀錄路徑上的所有區域
 * 然後再用region2往上追蹤，第一個在region1的路徑表中出現的區域就是要找的最小公共區域
 * 這個思路比較像235，236，可以試著把這個region看成一棵樹
 **/