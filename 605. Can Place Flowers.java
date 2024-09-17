// Easy
// Greedy
// O(m)
// https://leetcode.com/problems/can-place-flowers/

class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
      if (n == 0) return true;

      int len = flowerbed.length;
      for (int i = 0; i < len; i++) {
          if (flowerbed[i] == 0) {
              boolean emptyLeft = (i == 0 || flowerbed[i - 1] == 0); // 左邊花壇為空或是在邊界外
              boolean emptyRight = (i == len - 1 || flowerbed[i + 1] == 0); // 右邊花壇為空或是在邊界外
 
              if (emptyLeft && emptyRight) {
                  flowerbed[i] = 1;
                  n--;
                  if (n == 0) {
                      return true;
                  }
              }
          }
      }
      return n <= 0;
  }
}

/**
 * 種花問題：判斷是否可以在一排花壇中種下n朵花，並且保證沒有相鄰的花，需要找到一個方法來盡可能的多種花，同時不違反限制
 * 
 * 思路：我們可以遍歷整個數組，根據相鄰位置是否有花來決定當前空位是否可以種花
 * 對於那個空位，如果它的左右兩側為空或是在邊界，則可以在此為止種花，並將n減1
 **/