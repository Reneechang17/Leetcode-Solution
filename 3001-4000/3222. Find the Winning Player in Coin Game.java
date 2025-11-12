// Easy
// Simulation
// Time:O(1),Space:O(1)
// https://leetcode.cn/problems/find-the-winning-player-in-coin-game/

class Solution {
  // 75只能拿一个，两个就超标了。得到115的方法是1枚x（75），4枚y（40）
  public String winningPlayer(int x, int y) {
      int k = Math.min(x, y / 4);
      return k % 2 == 1 ? "Alice" : "Bob";
  }
}

// k: 我们最多可以进行x轮操作（x需要1个），但也不能超过y/4 轮（y需要4个）。
// -> 选择x和y/4中的较小值作为k，表示最多可以进行k轮完整操作
