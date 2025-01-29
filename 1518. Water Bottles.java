// Easy
// Simulate
// Time:O(logN),Space:O(1)
// https://leetcode.cn/problems/water-bottles/

class Solution {
  // Just simulation
  public int numWaterBottles(int numBottles, int numExchange) {
      int total = numBottles;
      while (numBottles >= numExchange) {
          int newBottles = numBottles / numExchange;
          int remaining = numBottles % numExchange;
          total += newBottles;
          numBottles = newBottles + remaining;
      }
      return total;
  }
}
