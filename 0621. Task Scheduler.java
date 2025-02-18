// Medium
// Greedy, Sorting
// O(n)
// https://leetcode.cn/problems/task-scheduler/

import java.util.Arrays;

class Solution {
  public int leastInterval(char[] tasks, int n) {
      // 統計每個任務的頻率
      int[] freq = new int[26];
      for (char task : tasks) {
          freq[task - 'A']++;
      }

      // 找到頻率最高的任務
      Arrays.sort(freq);
      int maxFreq = freq[25];
      int maxCount = 1;

      // 計算有多少個任務的頻率是最高的
      for (int i = 24; i >= 0; i--) {
          if (freq[i] == maxFreq) {
              maxCount++;
          } else {
              break;
          }
      }

      // 計算所需的最少時間
      // 框架大小為(maxFreq - 1) * (n + 1) ，加上最高頻率的任務個數
      int partCount = maxFreq - 1; // 構建空間框架的間隔數
      // int partLen = n + 1; // 每個間隔的長度
      int emptySlots = partCount * (n + 1 - maxCount); // 空閒位置，考慮到頻率相等的任務
      int remainingTasks = tasks.length - maxFreq * maxCount; // 剩餘任務
      int idleSlots = Math.max(0, emptySlots - remainingTasks); // 計算空閒

      return tasks.length + idleSlots; // 總時間 = 任務數 + 空閒數
  }
}
