// Easy
// String
// O(n)

class Solution {
  public String reverseStr(String s, int k) {
      // 因為Java的字符串不可變，所以先將字符串轉成字符數組
      char[] ch = s.toCharArray();
      // 遍歷字符數組，i每次迭代跳2k
      for(int i = 0; i < ch.length; i += 2 * k){
          // 判斷是否足夠k個
          // 如果足夠長，就反轉i到i+k-1索引
          if(i + k <= ch.length){
              reverse(ch, i, i + k - 1);
              continue;
          } else {
              // 不過不夠，全部反轉
              reverse(ch, i, ch.length - 1);
          }
      }
      return new String(ch); // 最後要把字符數組轉回字符串
  }
  // helper function用於實際反轉操作
  public void reverse(char[] ch, int i, int j){
      for(; i < j; i++, j--){
          char temp = ch[i];
          ch[i] = ch[j];
          ch[j] = temp;
      }
  }
}
