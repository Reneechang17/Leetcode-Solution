// Medium
// Greedy, Sorting
// O(n logn)
// Similar：300
// https://leetcode.com/problems/maximum-length-of-pair-chain/

import java.util.Arrays;
class Solution {
  public int findLongestChain(int[][] pairs) {
      Arrays.sort(pairs, (a, b) -> a[1] - b[1]); // sorting for index end

      int curEnd = Integer.MIN_VALUE;
      int count = 0;

      for (int[] pair : pairs) {
          // 可以形成chain
          if (pair[0] > curEnd) {
              curEnd = pair[1];
              count++;
          }
      }
      return count;
  } 
}

/**
 * 這題是給定一組數對，每個數對pairs[i] = [start, end]包含兩個整數，目標是選擇這些數對的一部分，讓他們成為一條chain
 * 要求是下一個數對的start值不能大於前一個數對的end值
 * 
 * 這題的目標是：1. 選擇哪些數對？ 2. 怎麼確保下一個的start大於當前的end？ 3. 形成盡可能最長且滿足條件的鏈
 * 我們可以發現：每次我們的選擇都要和上一個end做比較，那麼就要有一個變量來保存當前的end
 * 
 * 那為什麼end要先排序？？？
 * 可以舉一個比較極端的例子：[1, 2][4, 99][5, 23][24, 40]
 * 如果沒有排序，那麼我們結果是[1, 2][4, 99]，但我們發現[5, 23][24, 40]是可以成為chain的，並且可以和第一個數對接上，可以形成更長的chain：[1, 2][5, 23][24, 40]
 * 那因為我們需要盡可能長的chain，沒有排序會造成我們錯過更長的可能，所以可以對數對的end做一個排序，確保每次選擇的數對都是當前可能延續到最遲結束的數對
 * （這個最好是自己多做一點例子才能想出來。。。）
 * 
 * 排序後我們可以遍歷每一個數對，然後檢查當前的start是否大於當前儲存的end，如果是的話，更新curEnd為當前的end，並且count++
 **/