// Easy
// Array, Graph
// O(trust.length)
// Similar: 277
// https://leetcode.com/problems/find-the-town-judge/

class Solution {
  public int findJudge(int n, int[][] trust) {
    int[] trustCount = new int[n + 1];

    for (int[] relation : trust) {
      trustCount[relation[0]]--; // 出度：表示信任别人
      trustCount[relation[1]]++; // 入度：表示被別人信任
    }

    for (int i = 1; i <= n; i++) {
      if (trustCount[i] == n - 1) {
        return i;
      }
    }

    return -1;
  }
}

/**
 * 這題的題意和277相似，但是這次找的是法官，法官的定義是所有人都信任他，但是他不信任所有人
 * 
 * 這題可以用一個數組來表示每個人的信任度，對於每一個人，如果他信任別人，那麼他的信任度-1；如果他被別人信任，他的信任度+1
 * 最後檢查哪個人的信任度為n-1（即所有人都信任他，但是他不信任所有人），這個人就是法官
 * 可以用Graph來寫，出度表示信任別人，入度表示被別人信任
 **/