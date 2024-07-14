// Medium
// Array
// O(n)
// https://leetcode.com/problems/gas-station/

class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
      int total = 0;
      int cur = 0;
      int start = 0;

      for (int i = 0; i < gas.length; i++) {
          total += gas[i] - cost[i];
          cur += gas[i] - cost[i];
          if (cur < 0) {
              start = i + 1;
              cur = 0;
          }
      }
      return total >= 0 ? start : -1;
  }
}

/**
 * 一條環路有n個加油站，其中第i個加油站有gas[i]升汽油
 * 有一個無限量油箱的汽車，從第i個加油站開往第i+1個加油站需要消耗cost[i]升汽油，從其中一個加油站出發，開始時油箱為空
 * 給定兩個整數數組gas和cost，如果可以按順序繞環路行駛一週，則返回出發時加油站的編號，否則返回-1
 * 如果存在這個解，則保證他是唯一的
 * 
 * 這題可以看一下example會比較形象
 * 有一點可以先確認的，如果所有加油站的總油量少於總耗油量，就直接返回-1
 * 可以一次進行遍歷：從第一個加油站開始，用一個變數紀錄當前油量，若在某一站點的油量不足到達下一站，就把出發點設定為下一站，當前油量也設置0，繼續檢查
 **/