// Easy
// String
// O(n)
// https://leetcode.com/problems/reverse-string/

class Solution {
  public void reverseString(char[] s) {
      int left = 0, right = s.length - 1;
      while(left < right){
          char temp = s[left];
          s[left] = s[right];
          s[right] = temp;
          left++;
          right--;
      }
  }
}

/**
 * 思路：
 * 定義左右指針，分別從0和結尾處，向中間移動，互相交換（記得設temp）
 **/