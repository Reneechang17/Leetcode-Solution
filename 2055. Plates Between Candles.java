// Medium
// Prefix
// Time:O(n+q),Space:O(n)
// https://leetcode.cn/problems/plates-between-candles/

// My first idea is use Stack, but it can't guarantee the case like "|**|**|".
// The brute force is to find the first and last "|" by iteration, and finally calculate the plates between them, which results to O(q*n) complexity.
// For optimization, we can use binary search to find the position, but any possibility to lower complexity more?
// We can actually using PrefixSum to do that, the complexity can be O(n+q).

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] left = new int[n]; // left[i] means the closest candle from leftside
        int[] right = new int[n]; // right[i] means the closest candle from rightside
        int[] prefix = new int[n]; // means fore i's plates num

        int l = -1, r = -1, plateCnt = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (s.charAt(i) == '|')
                l = i;
            if (s.charAt(j) == '|')
                r = j;
            left[i] = l;
            right[j] = r;

            if (s.charAt(i) == '*') {
                plateCnt++;
            }
            prefix[i] = plateCnt;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            int firstCandle = right[start], lastCandle = left[end];

            if (firstCandle != -1 && lastCandle != -1 && firstCandle < lastCandle) {
                res[i] = prefix[lastCandle] - prefix[firstCandle];
            }
        }
        return res;
    }
}
