// Medium
// Backtracking
// Time:O(n^(target/min)), Space:O(target/min)
// https://leetcode.cn/problems/combination-sum/

import java.util.*;
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        // put start in backtracking bcz unlimit reuse the element
        backtracking(res, path, candidates, target, 0, 0); // sum and start
        return res;
    }

    private void backtracking(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int target, int sum, int start) {
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
