// Hard
// Backtracking, Math
// Time:O(n!),Space:O(n)
// https://leetcode.cn/problems/24-game/

import java.util.*;

class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int x : cards) {
            list.add((double) x);
        }
        return backtracking(list);
    }
    private boolean backtracking(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    List<Double> next = new ArrayList<>();
                    // iterate all element except list[i] and list[j]
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            next.add(list.get(k));
                        }
                    }
                    // try all operations between list[i] and list[j]
                    for (double res : compute(list.get(i), list.get(j))) {
                        next.add(res);
                        if (backtracking(next)) {
                            return true;
                        }
                        next.remove(next.size() - 1);
                    }
                }
            }
        }
        return false;
    }
    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(a * b);
        if (b != 0) {
            res.add(a / b);
        }
        return res;
    }
}
