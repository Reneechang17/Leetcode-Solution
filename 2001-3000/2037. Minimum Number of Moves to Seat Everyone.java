// Easy
// Array, Sorting
// O(n log n)
// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

import java.util.Arrays;

class Solution {
  public int minMovesToSeat(int[] seats, int[] students) {
      Arrays.sort(seats);
      Arrays.sort(students);

      int moves = 0;
      for (int i = 0 ; i < students.length; i++) {
          moves += Math.abs(seats[i] - students[i]);
      }
      return moves;
  }
}

/**
 * 簡單的數組排序對比題，但是題目有點繞
 * 
 * 直接對兩個數組進行排序，排序後對比每一個i的距離（用絕對值）並加總就是最少移動的次數826. Most Profit Assigning Work
 **/