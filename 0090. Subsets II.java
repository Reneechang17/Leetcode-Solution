// Medium
// Backtracking
// Time:O(n*2^n),Space:O(n)
// https://leetcode.cn/problems/subsets-ii/

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used; // avoid repeating the same element in the same recursion

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            res.add(path);
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        helper(nums, 0);
        return res;
    }

    // backtracking and check subsets
    private void helper(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        if (start >= nums.length) return;

        for (int i = start; i < nums.length; i++) {
            // check dup
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            path.add(nums[i]);
            used[i] = true;
            helper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
