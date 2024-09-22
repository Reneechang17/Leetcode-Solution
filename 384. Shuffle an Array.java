// Medium
// Random, Array, Fisher-Yates Algorithm
// O(n)
// https://leetcode.com/problems/shuffle-an-array/

import java.util.Random;

class Solution {
  private int[] original;
  private int[] currentArray;
  private Random random = new Random();

  public Solution(int[] nums) {
      original = nums.clone();
      currentArray = nums.clone();
  }
  
  public int[] reset() {
      currentArray = original.clone();
      return currentArray;
  }
  
  public int[] shuffle() {
      for (int i = currentArray.length - 1; i > 0; i--) {
          int j = random.nextInt(i + 1);
          swap(i, j);
      }
      return currentArray;
  }

  private void swap(int i, int j) {
      int tmp = currentArray[i];
      currentArray[i] = currentArray[j];
      currentArray[j] = tmp;
  }
}

/**
 * 打亂數組：將數組的元素位置打亂，每個元素的排列概率都相同
 * 思路：這題其實會用到一個算法叫做Fisher-Yates Algorithm，這個算法的基本思想是每次隨機選擇一個元素，然後和最後一個元素交換
 * 具體操作方式是從最後一個元素開始，隨機從0～i中選擇一個索引，然後交換這兩個元素
 * 至於reset方法就是直接返回原始的數組就好了，因此我們需要兩個數組一個保留原始數據，一個保留當前數據
 **/