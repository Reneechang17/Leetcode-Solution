// Medium
// Array
// O(n logn)
// https://leetcode.cn/problems/h-index/

import java.util.Arrays;

class Solution {
    // sort the citations, go through from tails
    // find the biggest i which can make citations[i] >= i + 1
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int index = 0;

        for (int i = 0; i < n; i++) {
            int cur = Math.min(citations[i], n - i);
            if (cur > index) {
                index = cur;
            }
        }
        return index;
    }
}
