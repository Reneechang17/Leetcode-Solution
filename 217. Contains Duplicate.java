// Easy
// Hash Table, Array
// O(n)
// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();

      for (int num : nums) {
          if (set.contains(num)) {
              return true;
          }
          set.add(num);
      }
      return false;
  }
}

/**
 * 找重複出現的元素，即出現兩次以上的：用set去重即可
 **/