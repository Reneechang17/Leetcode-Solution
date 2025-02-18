// Medium
// Two Pointers
// O(d)
// https://leetcode.com/problems/next-greater-element-iii/

class Solution {
  public int nextGreaterElement(int n) {
    char[] number = (n + "").toCharArray();

    int i, j;

    // 從右往左找到第一個不是遞增的數字
    for (i = number.length - 2; i >= 0; i--) {
      if (number[i] < number[i + 1]) {
        break;
      }
    }
    if (i == -1) {
      return -1;
    }

    // 在從右往左找到第一個比這個數字大的數字
    for (j = number.length - 1; j > 1; j--) {
      if (number[j] > number[i]) {
        break;
      }
    }

    // 交換一二步找到的兩個數字：使得當前數字局部變大
    swap(number, i, j);

    // 反轉步驟1找到的位置右邊的所有數字：使得這部分數字為最小可能值，確保得到的新數字盡可能小
    reverse(number, i + 1);

    try {
      return Integer.parseInt(new String(number));
    } catch (Exception e) {
      return -1;
    }
  }
  
  private void swap (char[] number, int i, int j) {
      char tmp = number[i];
      number[i] = number[j]; 
      number[j] = tmp;
  }

  private void reverse (char[] number, int start) {
      int end = number.length - 1;
      while (start < end) {
          swap(number, start, end);
          start++;
          end--;
      }
  }
}

/**
 * 下一個更大的元素III：給定一個32位正整數，找到這個數字的下一個更大的排列，如果這樣的排列不存在，則返回-1
 * 其中一個不存在的最好例子，比如整個數字都是降序排列，例如4321，不存在下一個更大的排列
 * 
 * 思路：
 * 1. 從右往左找到第一個不是遞增的數字
 * 2. 在從右往左找到第一個比這個數字大的數字
 * 3. 交換一二步找到的兩個數字：使得當前數字局部變大
 * 4. 反轉步驟1找到的位置右邊的所有數字：使得這部分數字為最小可能值，確保得到的新數字盡可能小
 * 
 * 例子：367的下一個更大的排列是376
 * 第一步先找到第一個不是遞增的數字：6
 * 第二步找到第一個比6大的數字：7
 * 第三步交換6和7：76
 * 第四步反轉6右邊的所有數字：376（6右邊沒有數字了）
 **/