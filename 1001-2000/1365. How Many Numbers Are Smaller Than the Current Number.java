// Easy
// Array
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/how-many-numbers-are-smaller-than-the-current-number/

// Actually I can't find any (looks smarter) way to do this....

import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] cnt = new int[n][2];

        for (int i = 0; i < n; i++) {
            cnt[i][0] = nums[i];
            cnt[i][1] = i;
        }

        Arrays.sort(cnt, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && cnt[i][0] == cnt[i - 1][0]) {
                res[cnt[i][1]] = res[cnt[i - 1][1]];
            } else {
                res[cnt[i][1]] = i; // i' smaller than it
            }
        }
        return res;
    }
}
