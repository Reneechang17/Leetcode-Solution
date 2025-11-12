// Medium
// Backtracking
// Time:O(n!),Space:O(n)
// https://leetcode.cn/problems/permutations/

import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        // used arr to avoid using the same element more than once
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, path, res);
        return res;
    }
    private void backtracking(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
