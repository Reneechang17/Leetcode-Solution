// Medium
// Binary Search, Sort
// Time:O(nlogn + mlogn), Space:O(n)
// https://leetcode.cn/problems/most-beautiful-item-for-each-query/

import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // sort items by value
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int n = items.length;
        int[] max = new int[n];
        max[0] = items[0][1];

        // fill max arr with max beauty values
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], items[i][1]);
        }

        // answer each query using binary search
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            // find the index of the largest value <= query
            int index = binarySearch(items, query);
            if (index == -1) {
                res[i] = 0;
            } else {
                res[i] = max[index];
            }
        }
        return res;
    }
    private int binarySearch(int[][] items, int query) {
        int left = 0, right = items.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] <= query) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
