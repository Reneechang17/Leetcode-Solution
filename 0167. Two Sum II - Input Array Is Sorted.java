// Medium
// Binary Search, Two Pointers
// O(nlogn)
// https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    // important info: sorted array, 1-indexted array
    // -> binary search, for each element in numbers, we need to find the
    // our goal is use bs to find target - numbers[i]
    public int[] twoSum(int[] numbers, int target) {
        // iterate the numbers
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            int x = target - numbers[i];

            // why <=? since we need to check the last element
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (numbers[mid] == x) {
                    // why +1? since this is 1-indexed array
                    // but java start index from 0
                    return new int[] {i + 1, mid + 1};
                } else if (numbers[mid] < x) {
                    // find the right side
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
 * 對於每個遍歷到的numbers[i]，用target減去numbers[i]，找他的配對值
 **/

// 另一種解法：雙指針
// 不推薦，題目有強調數組是排序的，所以應該利用這個特點
// O(n)
class Solution2 {
  public int[] twoSum(int[] numbers, int target) {
      int left = 0, right = numbers.length - 1;
      while (left < right) {
          int sum = numbers[left] + numbers[right];
          if (sum == target) {
              return new int[] {left + 1, right + 1};
          } else if (sum < target){
              left++;
          } else {
               right--;
          }
      }
      return new int[] {};
  }
}
