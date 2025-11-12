// Easy
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/first-bad-version/

// class Solution extends VersionControl {
//     public int firstBadVersion(int n) {
//         int left = 1, right = n;
//         while (left < right) {
//             int mid = left + (right - left) / 2; // prevent overflow...
//             if (isBadVersion(mid)) {
//                 right = mid;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return left;
//     }
// }

// 计算mid不能用(left+right)>>1或(left+right)/2
// 当left和right都是int时并其和都超出int范围时（java是2^31-1）
// 会发生溢出导致计算错误
