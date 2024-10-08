// Medium
// Array
// O(n)
// Similar: 997
// https://leetcode.cn/problems/find-the-celebrity/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    //   public class Solution extends Relation {
    //     public int findCelebrity(int n) {
    //         // 名人的定義是所有人都認識他，但是他不認識所有人
    //         int candidate = 0;
    //         for (int i = 1; i < n; i++) {
    //             if (knows(candidate, i)) {
    //                 candidate = i;
    //             }
    //         }
    
    //         for (int i = 0; i < n; i++) {
    //             if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
    //                 return -1;
    //             }
    //         }
    //         return candidate;
    //     }
    // }


/**
 * 找名人，名人的定義是所有人都認識他，但是他不認識任何其他人。有一個custom的API knows可以確定a是否認識b
 * 
 * 思路：可以用兩個for循環來做
 * 第一個for循環來找可能的名人，假設名人是第0個人，然後遍歷所有人，假設當前的名人認識另一個人，那麼假設的就不可能是名人，更新假設的名人為被認識的人
 * 第二個for循環來double check我們找出來的是不是名人，再遍歷所有人，確定這個假設的名人不認識任何人，并且所有人都認識他
 **/
