// Medium
// Two Pointers
// O(n)
// https://leetcode.com/problems/container-with-most-water/

class Solution {
  public int maxArea(int[] height) {
      int left = 0, right = height.length - 1;
      int maxArea = 0;

      while (left < right) {
          int minHeight = Math.min(height[left], height[right]);
          int curArea = minHeight * (right - left);
          maxArea = Math.max(maxArea, curArea);

          if (height[left] < height[right]) {
              left++;
          } else {
              right--;
          }
      }
      return maxArea;
  }
}

/**
 * 盛最多水的容器：給定一個整數數組height，其中height[i]代表點(i, 0)到點(i, height[i])的垂直線。需要找到兩條線，使得它們和x軸共同構成的容器可以容納最多的水
 * 
 * 思路：雙指針優化，通過縮減搜索空間來找到可能的最大容量，雙指針分別從數組開頭和結尾處向中間移動，每次移動較短那個線段的指針，直到兩個指針相遇
 * 這樣可以保證搜索空間是最大的，因為如果移動較長那個線段的指針，容器的底邊長度一定減小，而容器的高度不會增加，所以容器的容量一定減小
 * 當left小於right時，計算兩指針所指線段與x軸構成的容器容量，並嘗試更新最大水量
 **/