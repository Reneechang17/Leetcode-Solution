// Medium
// String, Two Pointers
// O(n)

class Solution {
  public void reverseWords(char[] s) {
      // use two pointers to reverse the words
      for(int i = 0, j = 0; j < s.length; j++){
          if(s[j] == ' '){
              reverse(s, i, j - 1);
              i = j + 1;
          } else if(j == s.length - 1) {
              reverse(s, i , j);
          }
      }
      // and then reverse the whole String
      reverse(s, 0, s.length - 1);
  }
  public void reverse(char[] s, int i, int j){
      for(; i < j; i++, j--){
          char temp = s[i];
          s[i] = s[j];
          s[j] = temp;
      }
  }
}
