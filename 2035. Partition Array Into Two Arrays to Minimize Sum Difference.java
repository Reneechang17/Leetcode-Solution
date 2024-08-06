// Hard
// Divide and Conquer, Hash Table, 
// O(2^n)
// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

import java.util.*;

class Solution {
  public int minimumDifference(int[] nums) {
    // 將數組分成兩個部分
    int n = nums.length >> 1;
    
    // f和g來存儲兩個子數組中所有可能子集和的映射（子集包含的元素個數，所有可能的和的集合）
    Map<Integer, Set<Integer>> f = new HashMap<>();
    Map<Integer, Set<Integer>> g = new HashMap<>();

    // 遍歷所有可能子集
    for (int i = 0; i < (1 << n); i++) {
      int sumF = 0, countF = 0; // sumF 和 countF用於計算第一部分的子集及其元素個數
      int sumG = 0, countG = 0; // sumG 和 countG用於計算第二部分的子集及其元素個數

      // 遍歷第一部分的每個元素，決定它是否加入子集
      for (int j = 0; j < n; j++) {
        // 如果第j位在i的二進制表示中是1
        if ((i & (1 << j)) != 0) {
          // 加入元素到子集F
          sumF += nums[j];
          countF++;
          sumG += nums[n + j]; // 處理第二部分的對應元素
          countG++;
        } else {
          // 不加入
          sumF -= nums[j];
          sumG -= nums[n + j];
        }
      }
      // 將計算得到的子集和與其元素個數的映射存儲在f和g中
      f.computeIfAbsent(countF, k -> new HashSet<>()).add(sumF);
      g.computeIfAbsent(countG, k -> new HashSet<>()).add(sumG);
    }

    int minDiff = Integer.MAX_VALUE;

    // 對於可能的元素個數i，查找兩部分中對應元素個數子集的和，嘗試找最小的差值
    for (int i = 0; i <= n; i++) {
      // 獲取元素個數為i的所有子集和
      List<Integer> listF = new ArrayList<>(f.get(i));
      // 獲取元素個數為n-i的所有子集和
      List<Integer> listG = new ArrayList<>(g.get(n - i));

      // 對兩個列表進行排序，以便有效做二分查找
      Collections.sort(listF);
      Collections.sort(listG);

      // 遍歷listF中的每個和，尋找在listG中最接近-sumF的和，以最小化｜sumF + sumG｜
      for (int sumF : listF) {
        int index = Collections.binarySearch(listG, -sumF);
        if (index < 0)
          index = -index - 1;
        if (index < listG.size())
          minDiff = Math.min(minDiff, Math.abs(sumF + listG.get(index)));
        if (index > 0)
          minDiff = Math.min(minDiff, Math.abs(sumF + listG.get(index - 1)));
      }
    }
    return minDiff;
  }
}

/**
 * 這題是一道高級組合優化問題（就很難），要求將數組分成兩個大小相同的部分，使得這兩個部分的元素總和差最小
 * 這個問題的複雜度在於當數組長度較大時，直接枚舉所有可能的分組方式是不切實際的，並且這題的數據量比較大
 * 
 * 解題思路：Meet in the Middle，適用於可以被分成兩個較小部分的問題，每個部分獨立處理後，再將結果合併以解決整個問題
 * 1. 將數組分成兩個等長的子數組
 * 2. 對於每個子數組，生成所有可能的子集和，由於每個子數組的長度為n/2，可以通過拉掩碼來遍歷可能的子集
 * 3. 哈希表根據子集包含的元素數量，存儲每種數量對應的所有子集和，當兩個子數組中選出的元素數量互補時（即一個選k個，另一個選n/2-k個），這兩個子集才可能組合成一個解
 * 4. 找最小和差，對於每一種元素數量，從兩個哈希表中取出對應的子集和列表，然後對這些列表進行排序。通過二分查找，為每個子集和找到最接近的反數，以此來最小化兩個部分的和差
 **/