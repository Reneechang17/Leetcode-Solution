// Medium
// Sliding Window, Hash Table
// O(n)
// https://leetcode.com/problems/repeated-dna-sequences/

import java.util.*;

class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
      List<String> res = new ArrayList<>();
      if (s.length() < 10) {
          return res;
      }
      Map<String, Integer> map = new HashMap<>();

      for (int i = 0; i <= s.length() - 10; i++) {
          String sub = s.substring(i, i + 10);
          map.put(sub, map.getOrDefault(sub, 0) + 1);
      }

      for (String key : map.keySet()) {
          if (map.get(key) > 1) {
              res.add(key);
          }
      }
      return res;
  }
}

/**
 * 重複的DNA序列：找到長度為10的所有在給定DNA序列中出現超過1次的子序列
 * 
 * 首先給定的序列可能會非常的長，我們需要找出所有長度為10的子序列，而這些子序列又至少出現兩次
 * 可以使用滑動窗口來找長度為10的子字符串，然後用哈希表對這些子字符串做計數，返回計數大於1的子字符串
 **/