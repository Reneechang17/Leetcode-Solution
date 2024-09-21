// Medium
// Array
// O(n)
// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
  public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] ans = new int[n];

      for (int i = 0, left = 1; i < n; i++) {
          ans[i] = left;
          left *= nums[i];
      }

      for (int i = n - 1, right = 1; i >= 0; i--) {
          ans[i] *= right;
          right *= nums[i];
      }
      return ans;
  }
}

/**
 * 除自身以外數組的乘積：給定一個數組，返回一個新的數組，新數組的每個元素是原數組中除了自身以外所有元素的乘積
 * 
 * 這題的思路比較簡單，就是先遍歷一遍，計算每個元素左邊的乘積，然後再遍歷一遍，計算每個元素右邊的乘積
 * 最後再將左右兩邊的乘積相乘即可
 * 
 * 具體做法：
 * 先從左到右遍歷數組，對於遍歷到的第i個元素，先用left更新ans[i]，然後在用left乘上nums[i]
 * 在從右到左遍歷數組，對於遍歷到的第i個元素，先更新ans[i]為ans[i] * right，然後right乘上nums[i]
 * **/