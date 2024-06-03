// Easy
// String
// O(n)

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