// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/watering-plants-ii/

class Solution {
  public int minimumRefill(int[] plants, int capacityA, int capacityB) {
      int left = 0, right = plants.length - 1;
      int waterA = capacityA, waterB = capacityB;
      int refills = 0;
      while (left <= right) {
          if (left == right) {
              // if alice and bob meet, the one with more water waters it
              if (Math.max(waterA, waterB) < plants[left]) {
                  refills++;
              }
          } else {
              // alice waters left, bob waters right
              if (waterA < plants[left]) {
                  refills++;
                  waterA = capacityA;
              }
              waterA -= plants[left];
              if (waterB < plants[right]) {
                  refills++;
                  waterB = capacityB;
              }
              waterB -= plants[right];
          }
          left++;
          right--;
      }
      return refills;
  }
}
