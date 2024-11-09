// Hard
// Greedy
// O(n)
// https://leetcode.cn/problems/candy/

class Solution {
    // 先確定右邊評分比左邊評分大的情況，只要右邊評分比左邊大，右邊孩子的糖果就+1
    // 再從後向前遍歷，確定左邊評分大於右邊評分的情況
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        arr[0] = 1;

        for (int i = 1; i < n; i++) {
            // 当前比左边大时，当前就是左边的+1，否则就是1
            arr[i] = (ratings[i] > ratings[i - 1] ? arr[i - 1] + 1 : 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        int ans = 0;
        for (int num : arr) {
            ans += num;
        }
        return ans;
    }
}
