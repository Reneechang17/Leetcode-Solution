// Medium
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-number-of-people-that-can-be-caught-in-tag/

import java.util.*;

class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        List<Integer> people = new ArrayList<>(), ghost = new ArrayList<>();
        for (int i = 0; i < team.length; i++) {
            if (team[i] == 0)
                people.add(i);
            else if (team[i] == 1)
                ghost.add(i);
        }

        int i = 0, j = 0, cnt = 0;

        while (i < people.size() && j < ghost.size()) {
            int p = people.get(i);
            int g = ghost.get(j);

            if (p < g - dist) {
                i++;
            } else if (p > g + dist) {
                j++;
            } else {
                cnt++;
                i++;
                j++;
            }
        }
        return cnt;
    }
}

class Solution2 {
    // Timeout...?
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int n = team.length, cnt = 0;
        boolean[] marked = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (team[i] == 1) {
                for (int j = Math.max(0, i - dist); j <= Math.min(n - 1, i + dist); j++) {
                    if (team[j] == 0 && !marked[j]) {
                        marked[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}
