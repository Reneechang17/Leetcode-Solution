// Medium
// Backtracking
// Time:O(n*2^n),Space:O(n)
// https://leetcode.cn/problems/subsets/

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0); 
        return res;
    }

    // the incoming start ensures each time the recursion starts from
    // diff starting point to avoid no repeated calculation and maintain order
    // -> there will be no [2, 1], only [1, 2]
    private void backtracking(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        if (start > nums.length) return;

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
