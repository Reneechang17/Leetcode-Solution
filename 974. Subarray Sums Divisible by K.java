import java.util.HashMap;
import java.util.Map;

// Medium
// Prefix Sum, Hash Table
// O(N)

class Solution {
  public int subarraysDivByK(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();
      // initialize: The remainder of 0 occurs once 
      // consider that the array itself is divisible by k
      count.put(0, 1); 
      int sum = 0, res = 0;
      for(int n : nums){
          sum += n; // update prefix
          // Since sum might be negative, so we need to do-> (sum % k + k) % k
          // to ensure that sum will not be negative 
          int modulus = (sum % k + k) % k;
          // times that current remainder occurs
          int sameModulusCount = count.getOrDefault(modulus, 0); 
          res += sameModulusCount;
          count.put(modulus, sameModulusCount + 1);
      }
      return res;
  }
}
