// Medium
// Simulation
// O(n)
// https://leetcode.com/problems/robot-bounded-in-circle/

class Solution {
  public boolean isRobotBounded(String instructions) {
      // 想不到什么解法可以试试看直接模拟
      int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int x = 0, y = 0;
      int init = 0; // 初始化朝北

      for (char instruction : instructions.toCharArray()) {
          if (instruction == 'G') {
              x += DIRECTIONS[init][0];
              y += DIRECTIONS[init][1];
          } else if (instruction == 'L') {
              init = (init + 3) % 4;
          } else if (instruction == 'R') {
              init = (init + 1) % 4;
          }
      }
      // 回到原点或是最终方向不朝初始化方向，代表困住了
      return (x == 0 && y == 0) || init != 0;
  }
}

/**
 * 機器人是否困在一個圓內：判斷機器人是否會在重複執行指後困在一個圓形軌跡中
 * 
 * 思路：這題其實聯想不到什麼DSA，這時候就可以考慮直接做模擬
 * 可以自己定義一個方向數組，初始化機器人朝北，然後根據指令來改變機器人的位置和方向
 * 最後判斷他是不是回到原點或者最終方向不朝北，如果是的話就代表困住了
 * 不被困住的條件是：如果機器人執行完操作後不在原點，或者最終方向是北方（即沒有改變方向），那麼他就不會被困在一個圓內，因為他可以一直向前走
 * 
 * 當機器人收到L指令時，他需要逆時針轉90度，也就是在索引中需要-1，但如果索引小於0（即等於-1），則說明他需要轉到最後一個方向，即+3
 * 當機器人收到R指令時，他需要順時針轉90度，也就是在索引中需要+1，但如果索引超過3（即等於4），則說明他需要轉回到北方，即+1
 **/