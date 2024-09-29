// Hard
// DP, Hash Table, Math, Memoization
// O(n)
// https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges/

import java.util.*;

class Solution {
  private Map<Integer, Integer> map = new HashMap<>();

  public int minDays(int n) {
      if (n <= 1) {
          return n;
      }

      if (map.containsKey(n)) {
        return map.get(n);
      }
      
      // 以下為DP思想的狀態轉移
      // 如果n是偶數，可以選擇吃掉一半的橘子，並遞歸處理n/2的情況，或是吃掉一個橘子
      int by2 = n % 2 + 1 + minDays(n / 2);

      // 如果n是可以被3整除，可以選擇吃掉2/3個橘子，並遞歸處理n/3的情況，或是吃掉一個橘子
      int by3 = n % 3 + 1 + minDays(n / 3);

      // 兩種情況取最小值
      int res = Math.min(by2, by3);
      map.put(n, res);
      
      return res;
  }
}

/**
 * 吃橘子的最少天數：給定n個橘子，要求在最少的天數吃完所有橘子，每天可以有三種吃法：
 * 1. 如果手上的橘子數可以被2整除，那麼每天可以吃掉一半的橘子
 * 2. 如果手上的橘子數可以被3整除，那麼每天可以吃掉三分之一的橘子
 * 3. 否則每天只能吃掉一個橘子
 * 
 * 思路：乍看之下這種min-max可以用二分來找，但是這題的狀態變化比較複雜，不是單純的線性變化，而且減少的數量也不一致
 * => 下一個狀態是可以由前一個狀態推導出來的，可以想到DP來解
 * 這題是典型的自頂向下遞歸的問題，可以從n個橘子開始，每天根據當前的橘子數量選擇最優的吃法，從而減少天數
 * 但是這個問題有重複子問題的特點，也就是不同天數剩下的橘子數量會重複，可以通過記憶化搜索來避免重複的計算（用哈希表來存儲）
 **/