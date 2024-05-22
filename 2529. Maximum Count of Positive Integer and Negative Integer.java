// Easy
// Array
// O(n)

class Solution {
  public int maximumCount(int[] nums) {
    int pos = 0, neg = 0;
    // iterate the number in nums and count
    // positive and negative directly
    for (int x : nums) {
      if (x > 0) {
        ++pos;
      } else if (x < 0) {
        ++neg;
      }
    }
    // return the bigger one
    return Math.max(pos, neg);
  }
}
