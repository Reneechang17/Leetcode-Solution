// Easy
// Map
// Time:O(n+m),Space:O(n+k)
// https://leetcode.cn/problems/minimum-index-sum-of-two-lists/

import java.util.*;

class Solution {
  // 找索引和最小的餐厅
  public String[] findRestaurant(String[] list1, String[] list2) {
      Map<String, Integer> map = new HashMap<>();
      for (int i = 0; i < list1.length; i++) {
          map.put(list1[i], i);
      }

      List<String> res = new ArrayList<>();
      int idxSum = Integer.MAX_VALUE;
      for (int j = 0; j < list2.length; j++) {
          if (map.containsKey(list2[j])) {
              int sum = j + map.get(list2[j]);

              if (sum < idxSum) {
                  res.clear();
                  res.add(list2[j]);
                  idxSum = sum;
              } else if (sum == idxSum) {
                  res.add(list2[j]);
              }
          }
      }
      return res.toArray(new String[0]);
  }
}
