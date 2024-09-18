// Medium
// DP, Recursion
// https://leetcode.com/problems/can-i-win/

import java.util.HashMap;

class Solution {
  private HashMap<Integer, Boolean> map = new HashMap<>();

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
      int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
      if (sum < desiredTotal) {
          return false;
      }
      if (desiredTotal <= maxChoosableInteger) {
          return true;
      }
      return helper(maxChoosableInteger, desiredTotal, 0);
  }

  private boolean helper(int maxChoosableInteger, int desiredTotal, int state) {
      if (map.containsKey(state)) {
          return map.get(state);
      }

      for (int i = 1; i <= maxChoosableInteger; i++) {
          if ((state & (1 << i)) == 0) {
              if (desiredTotal - i <= 0 || !helper(maxChoosableInteger, desiredTotal - i, state | (1 << i))) {
                  map.put(state, true);
                  return true;
              }
          }
      }
      map.put(state, false);
      return false;
  }
}

/**
 * Can I win?：博弈問題。給定整數maxChoosableInteger和desiredTotal，兩個玩家輪流從1到maxChoosableInteger中選擇數字，每次選擇的數字不能重複，直到總和達到desiredTotal為止
 * 如果兩名玩家都是最佳策略，第一個玩家是否能夠贏得比賽？
 * 
 * 思路：這題是經典的遞歸+記憶化搜索問題，需要找到所有可能的選擇方式，並判斷第一位玩家是否有辦法確保自己贏？
 * 核心
 * 1. 狀態表示：用二進制表示maxGuessableInteger個數字是否被選擇，例如maxGuessableInteger=3，二進制101表示數字1和3被選擇, 2沒有被選擇。遞歸過程會通過當前的狀態計算出下一步的狀態
 * 2. 遞歸：對於當前狀態，如果能找到一個數字，使得選擇這個數字後，剩餘的遊戲狀態讓對手無法贏，那麼當前玩家就能贏
 * 如果當前狀態下無論如何選擇，下一步對手總能贏，則當前玩家必輸
 * 3. 剪枝：如果desiredTotal <= maxChoosableInteger，則玩家只需要在第一步選擇等於或大於desiredTotal的數字即可贏
 * 如果所有數字和小於desiredTotal，無論如何選擇，兩個玩家都不可能達到desiredTotal，則第一個玩家必輸
 **/