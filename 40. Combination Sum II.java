// Medium
// Backtracking
// O(2^n) （實際情況應小於，因為有剪枝）
// Similar: 39
// https://leetcode.cn/problems/combination-sum-ii/

import java.util.*;

class Solution {
    // 組合總和，這題需要一個used數組來紀錄同一樹層上的是否使用過
    // 這題用set去重會超時
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    void backtracking(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }

            // 如果當前數字和前一個數字相同，並且前一個數字在當前層級沒有使用過，則跳過
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
