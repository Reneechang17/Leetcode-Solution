// Medium
// Sliding Window
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/count-the-number-of-good-subarrays/

import java.util.*;

class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long pairCnt = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int curCnt = map.getOrDefault(nums[right], 0);
            pairCnt += curCnt;
            map.put(nums[right], curCnt + 1);

            while (pairCnt >= k && left <= right) {
                res += n - right;

                int leftCnt = map.get(nums[left]);
                pairCnt -= (leftCnt - 1);
                map.put(nums[left], leftCnt - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }
        return res;
    }
}
