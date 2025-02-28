// Easy
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/guess-number-higher-or-lower/

// public class Solution extends GuessGame {
//     public int guessNumber(int n) {
//         int left = 1, right = n;
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             int res = guess(mid);
//             if (res == 0) {
//                 return mid;
//             } else if (res == -1) {
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return -1;
//     }
// }
