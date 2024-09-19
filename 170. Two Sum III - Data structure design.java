// Easy
// Design, Hash Table
// add: O(1), find: O(n)
// https://leetcode.com/problems/two-sum-iii-data-structure-design/

import java.util.HashMap;
import java.util.Map;

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

/**
 * 兩數之和III - 數據結構設計：要求設計一個數據結構，支持add和find操作：
 * add：將數字加到數據結構中
 * find：查找當前數據結構中是否存在兩個數到和為value
 * 
 * 思路：這題和經典two sum基本是類似的操作，只是變得更設計一點。一樣是用哈希表來紀錄每個數字出現的次數（add），對於每個添加的數字，需要檢查是否存在一個數字 value-num在哈希表中（find）
 * 如果當前num和value-num不相等，需要檢查哈希表中是否存在value-num
 * 如果當前num和value-num相等，則需要檢查哈希表中是否存在兩個以上的num，因為我們需要兩個相同的數字來構成value
 **/