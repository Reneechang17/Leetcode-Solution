// Medium
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/h-index-ii/

class Solution {
    // Find the potential H-index by binary search, since the input is sorted
    //  - find the citations[i] >= n - i, i will be left after binary search
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1, n = citations.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
