// Easy
// -
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/lemonade-change/

class Solution {
  public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;

    for (int i = 0; i < bills.length; i++) {
      // bill為5直接收下
      if (bills[i] == 5) {
        five++;
        // bill為10，收下10，找零5
      } else if (bills[i] == 10) {
        ten++;
        five--;
        // bill為20，優先消耗一個10 & 一個5，再不行就消耗三個5
      } else if (bills[i] == 20) {
        if (ten > 0 && five > 0) {
          ten--;
          five--;
        } else {
          five -= 3;
        }
      }
      if (five < 0 || ten < 0)
        return false;
    }
    return true;
  }
}

/**
 * 情況1：bill為$5, 直接收下
 * 情況2：bill為$10, 增加一個10 && 消耗一個5
 * 情況3：bill為$20, 優先消耗一個10和一個5，實在不行再消耗3個5（因為5更萬能
 **/