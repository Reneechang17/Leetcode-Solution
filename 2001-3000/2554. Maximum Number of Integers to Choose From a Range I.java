// Medium
// Set
// Time:O(n+m),Space:O(m)
// https://leetcode.cn/problems/maximum-number-of-integers-to-choose-from-a-range-i/

import java.util.*;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int b : banned) {
            set.add(b);
        }
        
        int cnt = 0, sum = 0;

        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }

            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            cnt++;
        }
        return cnt;
    }
}
