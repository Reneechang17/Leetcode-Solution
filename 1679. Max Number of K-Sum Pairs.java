// Medium
// Map, Two Pointers
// https://leetcode.cn/problems/max-number-of-k-sum-pairs/

import java.util.*;

class Solution {
    // Time:O(n), Space:O(n)
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int x : nums) {
            int target = k - x;

            if (map.getOrDefault(target, 0) > 0) {
                cnt++;
                map.put(target, map.get(target) - 1);
            } else {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        return cnt;
    }
}

class Solution2 {
    // Time:O(nlogn), Space:O(1)
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int cnt = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                cnt++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return cnt;
    }
}
