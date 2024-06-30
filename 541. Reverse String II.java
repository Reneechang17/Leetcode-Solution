// Easy
// String
// O(n)
// https://leetcode.com/problems/reverse-string-ii/

class Solution {
  public String reverseStr(String s, int k) {
      char[] ch = s.toCharArray();
      for(int i = 0; i < ch.length; i += 2 * k){
          if(i + k <= ch.length){
              reverse(ch, i, i + k - 1);
              continue;
          } else {
              reverse(ch, i, ch.length - 1);
          }
      }
      return new String(ch); 
  }
  public void reverse(char[] ch, int i, int j){
      for(; i < j; i++, j--){
          char temp = ch[i];
          ch[i] = ch[j];
          ch[j] = temp;
      }
  }
}

/**
 * Note: 因為Java的字符串是不可變的，所以要先轉換成字符數組
 * 1. 遍歷字符數組，i每次走2k步
 * 2. 先判斷是否足夠k個，如果足夠，就反轉i～i+k-1索引
 * 3. 如果不夠k個，就反轉全部
 * Note：最後return記得把字符數組反轉回字符串
 **/