// Medium
// Binary Search
// O(n logn)
// https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    // 題目重要的info：已排序 -> 可以考慮用二分
    // 遍歷numbers，對於每個遍歷到的元素，用target-numbers[i]，找當前元素的配對值
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1, x = target - numbers[i];

            // 不是left<right，是確保最後一個元素會被檢查到
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (numbers[mid] == x) {
                    // 加1是因為題目是1-indexed，而java數組是0-indexed
                    return new int[] {i + 1, mid + 1};
                } else if (numbers[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[] {};
    }
}

/**
 * 思路：雙指針
 * 優化：由於數組已經排序，可以用二分查找
 * 
 * 對於每個遍歷到的numbers[i]，用target減去numbers[i]，找他的配對值
 **/

// 另一種解法：雙指針
// 不推薦，1不是最優解，2題目有強調數組是排序的，所以應該利用這個特點
// O(n)
// class Solution {
//   public int[] twoSum(int[] numbers, int target) {
//       int left = 0, right = numbers.length - 1;
//       while (left < right) {
//           int sum = numbers[left] + numbers[right];
//           if (sum == target) {
//               return new int[] {left + 1, right + 1};
//           } else if (sum < target){
//               left++;
//           } else {
//                right--;
//           }
//       }
//       return new int[] {};
//   }
// }
