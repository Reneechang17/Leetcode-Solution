// Medium
// Array, Binary Search
// O(logn)
// https://leetcode.com/problems/h-index-ii/

class Solution {
  public int hIndex(int[] citations) {
      int low = 0, high = citations.length - 1;
      while (low <= high) {
          int mid = low + (high - low) / 2;
          if (citations[mid] >= citations.length - mid) {
              high = mid - 1;
          } else {
              low = mid + 1;
          }
      }
      return citations.length - low;
  }
}

/**
 * 這題的數組已經排序了，可以用二分查找來優化
 * 
 * 二分具體方法：
 * 1. 初始化邊界： low = 0， high = citations.length - 1
 * 2. 循環條件：當low小於等於high時
 * 3. 計算中間點
 * 4. 判斷條件：如果當前引用次數大於等於當前到數組末尾的論文數量，則可能的h指數至少為citations.length - mid，因此要向左繼續搜索
 **/