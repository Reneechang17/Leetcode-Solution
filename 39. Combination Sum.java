// Medium
// Backtracking
// Time:O(T^k) T is the target, k is the average depth of recursion
// Space:O(k)
// https://leetcode.cn/problems/combination-sum/

import java.util.*;
class Solution {
    // Use backtracking to find all combinations:
    // Start from cur index since unlimited reuse of the same candidate
    // If the cur sum equals the target, add the cur path to res
    //  - if the cur sum exceeds the target, stop it
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // sort to optimize pruning
        backtracking(res, path, candidates, target, 0, 0); // initialize the sum and start
        return res;
    }
    public void backtracking(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.removeLast();
        }
    }
}
