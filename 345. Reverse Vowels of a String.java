// Easy
// String
// O(n)
// https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution {
  public String reverseVowels(String s) {
      boolean[] vowels = new boolean[128];
      for(char c : "aeiouAEIOU".toCharArray()){
          vowels[c] = true;
      }
      char[] cs = s.toCharArray();
      int i = 0, j = cs.length - 1;
      while(i < j){
          while(i < j && !vowels[cs[i]]){
              ++i;
          }
          while(i < j && !vowels[cs[j]]){
              --j;
          }
          // switch
          if(i < j){
              char t = cs[i];
              cs[i] = cs[j];
              cs[j] = t;
              ++i;
              --j;
          }
      }
      return String.valueOf(cs);
  }
}

/**
 * 思路：
 * 先用vowels來遍歷字符串“aeiouAEIOU”，將對應的字符在數組位置設為true
 * 再用雙指針分別從頭尾向中間遍歷，遇到元音交換
 **/