// Medium
// Backtracking
// Time:O(n logn + 2^n),Space:O(target)
// https://leetcode.cn/problems/combination-sum-ii/

import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // facilitate avoid duplicates
        backtracking(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtracking(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            temp.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
