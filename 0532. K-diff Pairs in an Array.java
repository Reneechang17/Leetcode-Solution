// Medium
// Hash Table
// O(N)
// https://leetcode.com/problems/k-diff-pairs-in-an-array/

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int findPairs(int[] nums, int k) {
    Set<Integer> visited = new HashSet<>();
    Set<Integer> ans = new HashSet<>();

    for (int num : nums) {
      if (visited.contains(num - k)) {
        ans.add(num - k);
      }
      if (visited.contains(num + k)) {
        ans.add(num);
      }
      visited.add(num);
    }
    return ans.size();
  }
}

/**
 * 數組中的k-diff數對
 * 
 * 這題看一下example會比較好理解
 * 這種要unique的一般可以想到用set去重
 * 用增強for遍歷數組，分別尋找較小的元素(num-k)和較大的元素(num+k)
 * 
 * 
 * 
 * 較小的元素：檢查num-k在不在vis中，如果在，代表存在一對數num-k, num的差為k，那麼就把num-k加到ans中
 * 較大的元素：檢查num+k在不在vis中，如果是，代表當前的num可以和之前遇見的數配對，其差為k，因此把num放到ans中
 **/