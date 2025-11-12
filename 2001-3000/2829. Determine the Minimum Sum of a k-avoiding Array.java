// Medium
// Math
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/determine-the-minimum-sum-of-a-k-avoiding-array/

class Solution {
    public int minimumSum(int n, int k) {
        int m = k / 2 + 1;
        if (n < m) {
            return n * (n + 1) / 2;
        } else {
            return m * (m - 1) / 2 + (k + k + n - m) * (n - m + 1) / 2;
        }
    }
}

/**
 * 前m=k/2+1个数（即1,2,...,m-1）都不会和其他数相加得到k
 * 如果n≤m，直接取前n个数，它们是最小的n个数，总和为：S=n(n+1)/2
 * 如果n>m，先选1,2,...,m-1，然后选k,k+1,k+2,...填满n个数：
 * - 前m-1个数的总和：S1=m(m-1)/2
 * - 剩下的 (n-m+1) 个数是从k开始的等差数列：S2=(2k+(n-m))(n-m+1)/2
 * 最终总和：S=S1+S2
 */
