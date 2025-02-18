// Medium
// backtracking, Sorting
// O(4^n)
// https://leetcode.com/problems/matchsticks-to-square/

import java.util.Arrays;

class Solution {
  public boolean makesquare(int[] matchsticks) {
    int total = 0;
    for (int stick : matchsticks) {
      total += stick;
    }
    if (total % 4 != 0)
      return false;
    int side = total / 4;

    Arrays.sort(matchsticks);
    reverse(matchsticks);

    int[] sides = new int[4];
    return backtracking(matchsticks, sides, 0, side);
  }

  private boolean backtracking(int[] matchsticks, int[] sides, int index, int target) {
    if (index == matchsticks.length) {
      // check每一邊
      return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
    }

    for (int i = 0; i < 4; i++) {
      if (sides[i] + matchsticks[index] <= target) {
        sides[i] += matchsticks[index];
        if (backtracking(matchsticks, sides, index + 1, target)) {
          return true;
        }
        sides[i] -= matchsticks[index];
      }
      if (sides[i] == 0 || sides[i] + matchsticks[index] == target)
        break;
    }
    return false;
  }

  private void reverse(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
}

/**
 * 給定一個整數數組，其中matchsticks[i]是第i根火柴棒的長度，目標是用所有火柴棒拼成一個正方形
 * 條件：不能折斷火柴，但是可以對他們進行拼接
 * 
 * 這題和698比較像，其中k就是4，因為正方形有四個邊，每條邊的長度相等
 * 思路：
 * 1. 計算所有火柴數是否可以被4整除，並且找到沒邊的目標長度
 * 2. 對火柴棒從長到短排序，因為長的火柴棒比短的更難放置，可以更快找出失敗的方法
 * 3. 回溯：從最長的火柴棒開始，嘗試將每一根火柴棒放入四條邊的其中一邊，直到火柴棒用完或是確定無法構成正方形
 **/