// Easy
// Hash Table
// O(n)
// https://leetcode.com/problems/roman-to-integer/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int romanToInt(String s) {
      Map<Character, Integer> map = new HashMap<>();
      map.put('I', 1);
      map.put('V', 5);
      map.put('X', 10);
      map.put('L', 50);
      map.put('C', 100);
      map.put('D', 500);
      map.put('M', 1000);

      int sum = 0;
      for (int i = 0; i < s.length(); i++) {
          int value = map.get(s.charAt(i));
          if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
              sum -= value;
          } else {
              sum += value;
          }
      }
      return sum;
  }
}

/**
 * 將羅馬數字轉換成整數
 * 
 * 羅馬數字組合規則：
 * 1. 數字從左寫到右，從最小到最大
 * 2. 當小值在大值的左邊，則減去小值
 * 3. 當小值在大值的右邊，加小值
 * 
 * 思路：用map映射羅馬數字符號和其對應的整數值
 * 遍歷字符串，用map轉換每個符號
 * 根據規則操作
 **/