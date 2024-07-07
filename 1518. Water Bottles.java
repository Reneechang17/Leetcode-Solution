// Easy
// Math
// O(log(numBottles))
// https://leetcode.com/problems/water-bottles/

class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
      int total = numBottles;
      int empty = numBottles;

      while (empty >= numExchange) {
          int newBottle = empty / numExchange;
          total += newBottle;
          empty = empty % numExchange + newBottle;
      }
      return total;
  }
}

/**
 * 這題直接按照題目意思模擬即可
 * 一開始的total就是numBottles，喝完之後的empty也是numBottles
 * 當empty還可以和numExchange換的時候儘量換newBottle，這時候total應該加上那些新瓶子，而empty則是前一次剩下的瓶子+新瓶子
 **/