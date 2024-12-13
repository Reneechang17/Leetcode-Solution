// Hard
// Iteration
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/candy/

class Solution {
    // Iterate from left to right: if cur>left, cur candy = left + 1
    // Iterate from right to left: if cur>right, cur candy = max(cur, right + 1)
    // Finally sum up all candies
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        // 第一个孩子的糖果数量为1，因为每个孩子最少会有一颗糖
        arr[0] = 1;
        // left to right
        for (int i = 1; i < n; i++) {
            arr[i] = (ratings[i] > ratings[i - 1] ? arr[i - 1] + 1 : 1);
        }
        // right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }
        int ans = 0;
        for (int x : arr) {
            ans += x;
        }
        return ans;
    }
}
