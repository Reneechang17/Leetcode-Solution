// Easy
// HashSet, Two Pointers
// Time: O(nlogn), Space: O(n)
// https://leetcode.cn/problems/number-of-distinct-averages/

import java.util.*;

class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();

        int left = 0, right = nums.length - 1;
        while (left < right) {
            double avg = (nums[left] + nums[right]) / 2.0;
            set.add(avg);
            left++;
            right--;
        }
        return set.size();
    }
}
