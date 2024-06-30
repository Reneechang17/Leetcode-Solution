import java.util.HashMap;
import java.util.Map;

// Medium
// Prefix Sum, Hash Table
// O(N)
// Similar: 560
// https://leetcode.com/problems/subarray-sums-divisible-by-k/

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

/**
 * 思路：前綴和+哈希表
 * 用哈希表存儲當前餘數出現的次數（key：餘數，vlue：次數），初始化為餘數為0的情況出現1次（默認整個數組是可以被k整除的）
 * 遍歷數組，累加前綴和，計算餘數
 * Note：因為sum有可能是負數，所以要把sum % k 再加上k再模k，確保sum為非負數
 * 通過哈希表獲取當前餘數出現的次數
 **/