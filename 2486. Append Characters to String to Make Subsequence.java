// Medium
// String, Two Pointers
// O(n)

class Solution {
  public int appendCharacters(String s, String t) {
      int m = s.length(), n = t.length();
      // ij point to the begin of s & t
      // iterate t when s[i] != t[j], moving forward i
      for(int i = 0, j = 0; j < n; j++){
          while(i < m && s.charAt(i) != t.charAt(j)){
              ++i;
          }
          // if i is going to the end of s
          // means we can not find the t[j] in s
          // then we return the remain number of t
          if(i++ == m){
              return n - j;
          }
      }
      return 0;
  }
}
