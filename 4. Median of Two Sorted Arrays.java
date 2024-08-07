// Hard
// Divide and Conquer
// O(log(m + n))
// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;

    if (len % 2 == 1) {
      return f(nums1, 0, nums2, 0, len / 2 + 1);
    } else {
      return (f(nums1, 0, nums2, 0, len / 2) + f(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }
  }

  private int f(int[] A, int aStart, int[] B, int bStart, int k) {
    // base case: if one of the nums is null, then k will be in another one
    if (aStart >= A.length)
      return B[bStart + k - 1];
    if (bStart >= B.length)
      return A[aStart + k - 1];
    if (k == 1)
      return Math.min(A[aStart], B[bStart]);

    int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
    if (aStart + k / 2 - 1 < A.length)
      aMid = A[aStart + k / 2 - 1];
    if (bStart + k / 2 - 1 < B.length)
      bMid = B[bStart + k / 2 - 1];

    if (aMid < bMid) {
      return f(A, aStart + k / 2, B, bStart, k - k / 2);
    } else {
      return f(A, aStart, B, bStart + k / 2, k - k / 2);
    }
  }
}

/**
 * 首先從題目要求的時間複雜度O(log (m+n))可知這題絕對不是暴力解那麼簡單
 * 這題可以用二分查找來達成（因為有log）
 * 
 * 補充--暴力思路：
 * 將兩個數組merge在一個數組，將數組進行排序，然後用雙指針找中間數計算他的值 -> 超時
 * 
 * 題目要求找兩個排序數組的中位數，可以轉化思路改成去尋找兩個排序數組中第k小的數來解決
 * 需要考慮數組長度的奇偶數：奇數長度的中位數是(m + n)/2 + 1,偶數長度的中位數是(m + n)/2 和(m + n)/2 + 1的平均數
 * 
 * 可以設計遞歸函數去找：傳入兩個sorted的數組AB，以及AB分別的起始位置，還有要找兩個數組中第k小的元素
 * 每次遞歸比較AB數組中第k/2個元素（可以篩選掉一半元素）
 * 
 * 先解決basecase：1. 如果其中一個數組為空，那麼第k小的數就是另一個數組的第k個元素
 *                2. 如果k=1，那麼最小的數就是兩個數組開頭元素中較小的
 * 
 * 處理mid：初始化給mid設定infinite val，然後確定AB數組是否有足夠的元素考慮k/2個元素，如果有，就更新mid為相應的第k/2個元素
 * 二分查找主要更新的是兩個數組的起始位置，如果A數組的mid比B數組的mid小，那麼A數組的前k/2個元素不可能包含第k個元素，那麼我們就直接丟棄A數組的前k/2個元素
 **/