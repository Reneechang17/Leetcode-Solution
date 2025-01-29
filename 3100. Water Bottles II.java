// Medium
// Simulate
// Time:O(√numBottles), Space:O(n)
// https://leetcode.cn/problems/water-bottles-ii/

class Solution {
  // Simulate?
  public int maxBottlesDrunk(int numBottles, int numExchange) {
      // initialize 
      int total = numBottles;
      int emptyBottles = numBottles;

      while (emptyBottles >= numExchange) {
          // 用numExchange个空瓶换一个满水瓶
          emptyBottles -= numExchange;
          // 每次交换之后numExchange+1
          numExchange++;
          // 喝掉换来的满水瓶
          total++;
          // 喝完之后空瓶子+1
          emptyBottles++;
      }
      return total;
  }
}
