// Easy
// PrefixSum, Binary Search
// Time:O(nlogn + mlogn), Space:O(1)
// https://leetcode.cn/problems/longest-subsequence-with-limited-sum/

import java.util.Arrays;

class Solution {
    // Since this is easy, I think brute force should be work
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= queries[i]) {
                    cnt++;
                } else {
                    break;
                }
            }
            res[i] = cnt;
        }
        return res;
    }
}

// We can also optimize with binary search to find the last position <= queries[i]
class Solution2 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = binarySearch(nums, queries[i]);
            res[i] = index + 1;
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ret = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                ret = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ret;
    }
}
