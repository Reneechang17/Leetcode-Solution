// Medium
// Backtracking
// O(2^n)
// Similar: 77
// https://leetcode.cn/problems/combination-sum/

import java.util.*;

class Solution {
    // Backtracking, we need to find all possibilities
    // when we do backtrack, we can send the start -> can choose unlimited times
    // if the sum of cur path == target, add to res
    // if not, keep try sum + candidates[i]
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(res, path, candidates, target, 0, 0); // sum / start
        return res;
    }

    void backtracking(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.removeLast();
        }
    }
}
