// Easy
// Hash Table
// add: O(1), find: O(n)
// https://leetcode.cn/problems/two-sum-iii-data-structure-design/

import java.util.*;

class TwoSum {
  private Map<Integer, Integer> map;

  public TwoSum() {
      map = new HashMap<>();
  }
  
  public void add(int number) {
      map.put(number, map.getOrDefault(number, 0) + 1);
  }
  
  public boolean find(int value) {
      for (int num : map.keySet()) {
          int target = value - num;
          if (target != num) {
              if (map.containsKey(target)) {
                  return true;
              }
          } else {
              if (map.get(num) > 1) {
                  return true;
              }
          }
      }
      return false;
  }
}
