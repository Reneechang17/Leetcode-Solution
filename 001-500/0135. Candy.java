// Hard
// Simulation
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/candy/

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        arr[0] = 1; // each child has at least 1 candy
        
        // iterate from left to right, if cur > left, cur = left + 1
        for (int i = 1; i < n; i++) {
            arr[i] = (ratings[i] > ratings[i - 1] ? arr[i - 1] + 1 : 1);
        }

        // iterate from right to left, if cur > right, cur = max(cur, right + 1)
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        int ans = 0;
        for (int x : arr) ans += x;
        return ans;
    }
}
