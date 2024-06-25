// Medium
// QuickSelect
// O(n)
// https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
  public int findKthLargest(int[] nums, int k) {
      int n = nums.length;
      // 把問題轉換成找第nums.length - k小的元素
      return quickSelect(nums, 0, n - 1, n - k);
  }
  private int quickSelect (int[] nums, int left, int right, int k) {
      // 當搜索範圍縮小到只有一個元素的時候，直接返回那個元素
      if (left == right) { 
          return nums[left];
      }
      // 計算中點
      int splitIndex = (left + right) >>> 1;
      int split = nums[splitIndex];
      int i = left, j = right;

      while (i <= j) {
          while (nums[i] < split) {
              i++;
          }
          while (nums[j] > split) { 
              j--;
          }
          if (i <= j) {
              swap (nums, i, j);
              i++;
              j--;
          }
      }
      if (k <= j) {
          return quickSelect (nums, left, j, k);
      }
      if (k >= i) {
          return quickSelect (nums, i, right, k);
      }
      return nums[k];
  }

  private void swap (int[] nums, int a, int b) {
      int temp = nums[a];
      nums[a] = nums[b];
      nums[b] = temp;
  }
}

/**
 * 首先這題讓我們避免使用sorting所以就不要往sorting去思考
 * 
 * 這題可以用快速選擇(quickSelect)方法 => 用於查找數組中第k個最大（最小）元素很有效，可以將時間複雜度壓到O(n)
 * review：快速選擇算法操作 1. 選擇一個樞紐元素， 通常是數組的第一個元素（left） 2.分區（把比樞紐元素小的都放到左邊，反之放右邊）3. 遞歸：樞紐元素的位置可以用來判斷第k個最大or最小元素在左邊還是右邊，如果樞紐元素正好是k，就返回k；如果樞紐元素比k小，就在數組的右邊找；如果樞紐元素比k大，就在數組的左邊找
 * 
 * 這題是找第k個最大元素，那反過來就是第nums.length - k 個最小元素
 * 
 * Note：1. 計算中點的時候要注意溢出 2. i & j的更新情況（要考慮數組中有重複元素的情況，可能會有無限循環導致超時）
 **/