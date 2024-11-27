// Easy
// Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/contains-duplicate/

import java.util.*;

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

// 空间优化：可以先排序，再遍历数组，判断相邻元素是否相等
// Time:O(nlogn), Space:O(1)
class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
