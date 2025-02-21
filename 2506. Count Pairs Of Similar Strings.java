// Easy
// Hash Table
// Time:O(n*m),Space:O(n*m)
// https://leetcode.cn/problems/count-pairs-of-similar-strings/

import java.util.*;

class Solution {
  public int similarPairs(String[] words) {
      // use Map to store the appear time of each string
      Map<String, Integer> map = new HashMap<>();
      int count = 0;
      
      for (String word : words) {
          // convert each string to char set
          Set<Character> set = new HashSet<>();
          for (char c : word.toCharArray()) {
              set.add(c);
          }
          // convert char set to string
          String key = set.toString();

          // if map contain this char set, count++
          if (map.containsKey(key)) {
              count += map.get(key);
          }
          map.put(key, map.getOrDefault(key, 0) + 1);
      }
      return count;
  }
}
