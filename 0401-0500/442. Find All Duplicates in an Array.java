// Medium
// Array, Hash Table
// O(n)
// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    // set can use to filter the duplicate the elements
    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
      if (set.contains(num)) {
        res.add(num);
      } else {
        set.add(num);
      }
    }
    return res;
  }
}

/**
 * 思路：可以用set去重
 * 我們可以遍歷數組，如果這個integer沒有出現在set中，那就加入set
 * 如果出現在set中，代表重複了，就加入res
 **/