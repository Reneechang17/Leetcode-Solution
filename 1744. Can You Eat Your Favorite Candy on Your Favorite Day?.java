// Medium
// Prefix
// Time:O(n+q),Space:O(n)
// https://leetcode.cn/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/

// This problem statement is pretty hard to read:D The core question is like the title says.
// So, we want to eat No.favoriteType' candy on favoriteDay(0-indexed).
// The slowest way: we eat one candy each day => favDay + 1 >= fore candies' sum + 1
// The fastest way: We eat dailyCap candies each day, but we can't each the target candy before favDay
// => (fav + 1) * dailyCap > fore candies' sum

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] prefix = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + candiesCount[i - 1];
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0], day = queries[i][1], cap = queries[i][2];

            // Candy's range
            long minCandy = prefix[type] + 1;
            long maxCandy = prefix[type + 1];

            // Eating range
            long minEat = day + 1;
            long maxEat = (long) (day + 1) * cap;

            // check if it covers the target candy's in the range
            ans[i] = !(maxEat < minCandy || minEat > maxCandy);
        }
        return ans;
    }
}
