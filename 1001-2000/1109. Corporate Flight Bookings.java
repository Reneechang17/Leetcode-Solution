// Medium
// Difference Array
// Time:O(n+m), Space:O(n)
// https://leetcode.cn/problems/corporate-flight-bookings/

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // diff[] from index 1 to index n
        int[] diff = new int[n + 2];

        for (int[] b : bookings) {
            int l = b[0], r = b[1], seats = b[2];
            diff[l] += seats;
            diff[r + 1] -= seats;
        }

        int[] res = new int[n];

        // res[] from index 0 to index n - 1
        res[0] = diff[1];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i + 1];
        }
        return res;
    }
}
