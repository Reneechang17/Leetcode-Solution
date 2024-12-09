// Medium
// Count
// Time:O(121*121)->O(1), Space:O(121)
// https://leetcode.cn/problems/friends-of-appropriate-ages/

class Solution {
  // create an arr count, record the appear num of each age
  // iterate all possible (A, B), follow rules to count it
  public int numFriendRequests(int[] ages) {
      int[] count = new int[121];
      for (int age : ages) {
          count[age]++;
      }
      int res = 0;
      for (int a = 1; a <= 120; a++) {
          if (count[a] == 0) continue;
          for (int b = 1; b <= 120; b++) {
              if (count[b] == 0) continue;
              if (b <= 0.5 * a + 7) continue;
              if (b > a) continue;
              res += count[a] * count[b];
              if (a == b) {
                  res -= count[a]; // subtract duplicate request
              }
          }
      }
      return res;
  }
}
