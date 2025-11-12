// Easy
// Simulate
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/watering-plants/

class Solution {
  public int wateringPlants(int[] plants, int capacity) {
      int steps = 0, curWater = capacity;
      for (int i = 0; i < plants.length; i++) {
          if (curWater >= plants[i]) {
              // 浇水
              curWater -= plants[i];
              steps++;
          } else {
              // 回去补水
              steps += 2 * i;
              curWater = capacity - plants[i];
              steps++;
          }
      }
      return steps;
  }
}
