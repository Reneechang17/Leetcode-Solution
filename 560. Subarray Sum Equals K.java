import java.util.HashMap;
import java.util.Map;

// Medium
// Prefix, Hash Table
// O(n)
// Similar: 974

class Solution {
  public int subarraySum(int[] nums, int k) {
      Map<Integer, Integer> count = new HashMap<>();
      count.put(0, 1);

      int currentSum = 0, res = 0;
      for(int num : nums){
          currentSum += num;
          res += count.getOrDefault(currentSum - k, 0);
          count.put(currentSum, count.getOrDefault(currentSum, 0) + 1);
      }
      return res;
  }
}
