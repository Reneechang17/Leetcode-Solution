// Easy
// String
// O(n)
// https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution {
  public String reverseWords(String s) {
      StringBuilder sb = new StringBuilder();
      for(String str : s.split(" ")){
          for(int i = str.length() - 1; i >= 0; --i){
              sb.append(str.charAt(i));
          }
          sb.append(" ");
      }
      return sb.substring(0, sb.length() - 1);
  }
}

/**
 * Note: 因為Java的字符串是不可變的，所以要先轉換成字符數組
 * 1. 遍歷字符數組，i每次走2k步
 * 2. 先判斷是否足夠k個，如果足夠，就反轉i～i+k-1索引
 * 3. 如果不夠k個，就反轉全部
 * Note：最後return記得把字符數組反轉回字符串
 **/