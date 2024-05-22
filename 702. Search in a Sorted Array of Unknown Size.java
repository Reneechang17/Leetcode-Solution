// Medium
// Array, Binary Search
// O(log n)

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

interface ArrayReader {
    public int get(int index);
}

// the solution is similar to Leetcode 704
class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 20000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return reader.get(left) == target ? left : -1;
    }
}
