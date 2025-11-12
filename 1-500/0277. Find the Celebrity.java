// Medium
// Array
// O(n)
// Similar: 997
// https://leetcode.cn/problems/find-the-celebrity/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    //   public class Solution extends Relation {
    //     public int findCelebrity(int n) {
    //         int candidate = 0;
    
    //         // 假設當前celebrity是第0個人，然後遍歷所有人
    //         for (int i = 1; i < n; i++) {
    //             // 如果當前的celebrity認識別人，那麼他就不會是要找的人
    //             if (knows(candidate, i)) {
    //                 // 更新celebrity成為當前假設所認識的人
    //                 candidate = i;
    //             }
    //         }
    
    //         // double check這個人是不是celebrity
    //         for (int i = 0; i < n; i++) {
    //             // 如果這個candidate認識別人 或是 其中一個人不認識這個candidate
    //             // 這個candidate就不是我們要找的celebrity
    //             if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
    //                 return -1;
    //             }
    //         }
    //         return candidate;
    //     }
    // }
