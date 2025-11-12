// Medium
// DP
// O(n)
// https://leetcode.com/problems/paint-fence/

class Solution {
  public int numWays(int n, int k) {
      if (n == 0) return 0;
      if (n == 1) return k;

      int same = k;
      int diff = k * (k - 1);

      for (int i = 3; i <= n; i++) {
          int prevDiff = diff;
          diff = (same + diff) * (k - 1);
          same = prevDiff;
      }
      return same + diff;
  }
}

/**
 * 有n根柵欄和k種顏色，需要給柵欄塗色，不能有超過兩根相鄰的柵欄塗上相同的顏色
 * 
 * 那麼對於每根柵欄，可以選擇：1. 與前一根顏色相同 2. 與前一根顏色不同
 * 需要兩個變量來跟蹤：same表示當前柵欄與前一根柵欄顏色相同時的方案 diff表示當前柵欄和前一根柵欄顏色不同的檔案
 * 
 * 狀態轉移：
 * 1. 當前要和前一根同色時，那麼前一根就必須與其前一根顏色不同 => same[i] = diff[i - 1]
 * 2. 當前和前一根不同色時，可以從k-1種其他顏色中選擇（因為不能和前一根相同）
 * 
 * 初始化：第一根可以用k中顏色塗色，第二根柵欄如果和第一根相同，則有k中選擇；如果不同，有k\times(k - 1)種
 **/