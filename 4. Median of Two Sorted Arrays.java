// Hard
// Divide and Conquer
// O(log(m + n))
// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
  // 如果两个数组的总长度为奇数，则中位数是合并后排序数组的第(tot / 2 + 1) 个元素
  // 如果总长度为偶数，则中位数为第 (tot / 2) 和 (tot / 2 + 1) 个元素的平均值
  // 用递归find(int[] nums1, int i, int[] nums2, int j, int k) 用来找到 nums1 和 nums2 中第 k 小的元素
  // nums1 和 nums2 都是有序数组，i 和 j 分别是当前在 nums1 和 nums2 中的起始位置
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int tot = nums1.length + nums2.length;
      // 关键点 找到合并后第k个元素
      if (tot % 2 == 0) {
          int left = find(nums1, 0, nums2, 0, tot / 2);
          int right = find(nums1, 0, nums2, 0, tot / 2 + 1);
          return (left + right) / 2.0;
      } else {
          return find(nums1, 0, nums2, 0, tot / 2 + 1);
      }
  }

  private int find(int[] nums1, int i, int[] nums2, int j, int k) {
      if (nums1.length - i > nums2.length - j) return find(nums2, j, nums1, i, k);
      if (k == 1) {
          if (i == nums1.length) return nums2[j];
          else return Math.min(nums1[i], nums2[j]);
      }
      if (i == nums1.length) return nums2[j + k - 1];
      int si = Math.min(nums1.length, i + k / 2), sj = j + (k - k / 2);
      if (nums1[si - 1] < nums2[sj - 1]) {
          return find(nums1, si, nums2, j, k - (si - i));
      } else {
          return find(nums1, i, nums2, sj, k - (sj - j));
      }
  }
}

/**
 * 首先從題目要求的時間複雜度O(log (m+n))可知這題絕對不是暴力解那麼簡單
 * 這題可以用二分查找來達成
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
