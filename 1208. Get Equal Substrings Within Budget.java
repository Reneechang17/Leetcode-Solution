// Medium
// LinkedList, Sliding Window, Two Pointers
// O(n)

class Solution {
  public int equalSubstring(String s, String t, int maxCost) {
      int len = s.length();
      int sum = 0, ans = 0;
      for(int i = 0, j = 0; i < len; ++i){
          sum += Math.abs(s.charAt(i) - t.charAt(i));
          while(sum > maxCost){
              sum -= Math.abs(s.charAt(j) - t.charAt(j));
              ++j;
          }
          ans = Math.max(ans, i - j + 1);
      }
      return ans;
  }
}
