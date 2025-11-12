// Easy
// Array, Sorting
// O(n logn)
// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

import java.util.stream.IntStream;

class Solution {
  public int largestSumAfterKNegations(int[] nums, int k) {
      nums = IntStream.of(nums).boxed().sorted((a, b) -> Math.abs(b) - Math.abs(a)).mapToInt(Integer::intValue).toArray();

      int n = nums.length;
      for (int i = 0; i < n; i++) {
          if (nums[i] < 0 && k > 0) {
              nums[i] = -nums[i];
              k--;
          }
      }

      if (k % 2 == 1) {
          nums[n - 1] = -nums[n - 1];
      }

      int sum = 0;
      for (int num : nums) {
          sum += num;
      }
      return sum;
  }
}

/**
 * 選擇某個索引i並將A[i] 替換成-A[i]，重複這個過程k次，允許多次選擇同一個索引i，返回修改後數組的可能最大和
 * 
 * 這題可以從example中看出一些規律：
 * 1. 如果有負數，優先將負數轉換為正數，有零的話可以取代正數轉負數
 * 並且如果k剩下的次數為偶數的話，負數還是可以轉成正數，如果剩下的次數為奇數，就把最小的轉換
 * 2. 如果都是正數，優先選擇小的轉換
 * 3. 絕對值大的負數轉成正數
 * 
 * 由上面規律可以看出，勢必要對數組內的元素進行排序，這樣可以快速定位最小/最大的數
 * 遍歷數組，如果當前元素為負數，並且k剩下的次數大於0，則轉換當前的元素
 * 
 * 如果處理完所有負數後，k剩下的次數為奇數，則優先把小的數先轉換
 * 最後遍歷數組中所有元素，累加總和
 **/