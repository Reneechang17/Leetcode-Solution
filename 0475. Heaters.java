// Medium
// Binary Search, Sliding Window
// Time:O((n+m)log(maxRadius)), Space:O(1)
// https://leetcode.cn/problems/heaters/

import java.util.Arrays;

class Solution {
  // 每个加热器可以覆盖的范围是[heater-radius, heater+radius]->目标是找到一个最小半径，可以让每个房屋都至少被一个heater覆盖
  // 可以直接对半径r做二分，判断给定半径能不能覆盖所有房子
  // 具体做法：排序houses和heaters，对半径r做二分，如果当前r可以覆盖，则尝试更小的，否则增加半径->二分找最小
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int left = 0, right = (int) 1e9;
    while (left < right) {
      int mid = (left + right) >> 1;
      if (canCover(houses, heaters, mid)) {
        right = mid; // 可以的话尝试找更小的半径
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  // 检查在当前半径下，所有房屋是否被一个加热器覆盖
  private boolean canCover(int[] houses, int[] heaters, int radius) {
    int i = 0; // point to heater
    for (int house : houses) {
      // 当前加热器的右边界小于房屋的位置，说明这个加热器无法覆盖当前房屋，需要移动到下一个加热器
      while (i < heaters.length && heaters[i] + radius < house) {
        i++; // move to next heater
      }

      // 所有加热器都遍历完 OR 当前加热器的左边界大于房屋的位置，说明这个加热器也不能覆盖当前房屋
      if (i == heaters.length || heaters[i] - radius > house) {
        return false; // 表示当前房屋不能被任何加热器覆盖
      }
    }
    return true;
  }
}
