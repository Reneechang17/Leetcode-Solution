// Medium
// Hash Table, Sliding Window
// O(m + n)
// Similar: 76, 438

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean checkInclusion(String s1, String s2) {
      // use hashmap to record the times of each char in s1
      Map<Character, Integer> need = new HashMap<>();
      Map<Character, Integer> window = new HashMap<>();
      for(int i = 0; i < s1.length(); i++){
          char c = s1.charAt(i);
          need.put(c, need.getOrDefault(c, 0) + 1);
      }

      // initialize the window, set left/right/valid number
      int left = 0, right = 0, valid = 0;
      // start expand the window(move right)
      while(right < s2.length()){
          char c = s2.charAt(right);
          right++;
          // update window
          if(need.containsKey(c)){
              window.put(c, window.getOrDefault(c, 0) + 1);
              if(window.get(c).equals(need.get(c))){
                  valid++;
              }
          }
          // check when to shrink the window
          // when right - left >= s1.length()
          while(right - left >= s1.length()){
              // first check if find the valid substring
              if (valid == need.size())
                return true;
              // then deal with the drop char
              char d = s2.charAt(left);
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
      return false;
  }
}
