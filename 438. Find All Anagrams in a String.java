// Medium
// Hash Table, Sliding Window
// O(m + n)
// https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
      Map<Character, Integer> need = new HashMap<>();
      Map<Character, Integer> window = new HashMap<>();
      for(char c : p.toCharArray()){
          need.put(c, need.getOrDefault(c, 0) + 1);
      }

      int left = 0, right = 0;
      int valid = 0;
      List<Integer> res = new ArrayList<>();
      while(right < s.length()){
          char c = s.charAt(right);
          right++;

          // update window
          if(need.containsKey(c)){
              window.put(c, window.getOrDefault(c, 0) + 1);
              if(window.get(c).equals(need.get(c))){
                  valid++;
              }
          }

          // check when to shrink the window
          // when right-left >= p
          while(right - left >= p.length()){
              if(valid == need.size())
                  res.add(left);
              char d = s.charAt(left);
              left++;

              // update window
              if(need.containsKey(d)){
                  if(window.get(d).equals(need.get(d))){
                      valid--;
                  }
                  window.put(d, window.get(d) - 1);
              }
          }
      }
      return res;
  }
}

/**
 * 1. 先遍歷需要的String，用哈希表紀錄每個字符出現的次數
 * 2. 初始化窗口（左右指針以及合法個數）
 * 3. 擴大窗口（right++）& 更新窗口
 * 4. 當窗口大小（right-left）超過p的長度時，收縮窗口 & 更新窗口
 * Note：需要先看valid是不是等於need的長度
 **/