// Medium
// Array, Hash Table
// O(n)

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
