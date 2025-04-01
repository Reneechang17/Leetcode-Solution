// Medium
// LCA, DFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/smallest-common-region/

import java.util.*;
class Solution {
  // Transfer thr problem to LCA -> find the LCA of regions1 and regions2
  public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
      // construct parentMap <child regions, it's parent>
      Map<String, String> parentMap = new HashMap<>();
      for (List<String> region : regions) {
          for (int i = 1; i < region.size(); i++) {
              parentMap.put(region.get(i), region.get(0));
          }
      }
      
      // find regions1' path
      Set<String> path1 = new HashSet<>();
      while (region1 != null) {
          path1.add(region1);
          region1 = parentMap.get(region1);
      }

      // find region2' path and find first crossing 
      while (region2 != null) {
          if (path1.contains(region2)) {
              return region2;
          } 
          region2 = parentMap.get(region2);
      }
      return ""; 
  }
}
