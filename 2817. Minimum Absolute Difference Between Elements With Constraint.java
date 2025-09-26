// Medium
// TreeSet
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/minimum-absolute-difference-between-elements-with-constraint/

import java.util.*;;

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        int minDiff = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();

        for (int j = 0; j < n; j++) {
            if (j >= x) {
                set.add(nums.get(j - x));
            }

            if (!set.isEmpty()) {
                Integer floor = set.floor(nums.get(j));
                Integer ceiling = set.ceiling(nums.get(j));

                if (floor != null) {
                    minDiff = Math.min(minDiff, Math.abs(nums.get(j) - floor));
                }

                if (ceiling != null) {
                    minDiff = Math.min(minDiff, Math.abs(nums.get(j) - ceiling));
                }
            }
        }
        return minDiff;
    }
}
