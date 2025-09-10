// Medium
// Greedy, Simulation
// Time:O(n*m + friendships.length), Space:O(m* avg lang numbers)
// https://leetcode.cn/problems/minimum-number-of-people-to-teach/

// The first idea is greedy... but have no further idea...
// And Claude said we can use Greedy+Simulation..?

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // Put the language to set
        int m = languages.length;
        Set<Integer>[] set = new Set[m + 1];

        for (int i = 0; i < m; i++) {
            set[i + 1] = new HashSet<>();
            for (int lang : languages[i]) {
                set[i + 1].add(lang);
            }
        }

        // find pairs need to teach
        Set<Integer> need = new HashSet<>();
        for (int[] friends : friendships) {
            int u = friends[0], v = friends[1];

            // check if they have common lang
            if (!hasCommonLang(set[u], set[v])) {
                need.add(u);
                need.add(v);
            }
        }

        // if all can communicate, no need for teach
        if (need.isEmpty())
            return 0;

        // go through each lang, the worse case is teach all need
        int minTeach = need.size();
        for (int lang = 1; lang <= n; lang++) {
            int cnt = 0;

            for (int p : need) {
                if (!set[p].contains(lang)) {
                    cnt++;
                }
            }
            minTeach = Math.min(minTeach, cnt);
        }
        return minTeach;

    }
    
    private boolean hasCommonLang(Set<Integer> s1, Set<Integer> s2) {
        // find the smaller set
        if (s1.size() > s2.size()) {
            Set<Integer> tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        for (int lang : s1) {
            if (s2.contains(lang))
                return true;
        }
        return false;
    }
}
