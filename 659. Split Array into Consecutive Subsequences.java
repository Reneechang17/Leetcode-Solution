// Medium
// Greedy, HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/split-array-into-consecutive-subsequences/

import java.util.*;

// Actually my first idea is pq but later found we don't need to care about order,
// so it's obvious that pq not a good idea.
// For more efficiency idea is maintain two hashmap, one store the freq of each integer,
// another is used to see if there is a subseq wait for current number.
// That would be the better way to check it could form the subseq we want.

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int x : nums) {
            if (freq.get(x) == 0)
                continue;

            // if there is a subseq wait for this number
            if (need.getOrDefault(x, 0) > 0) {
                freq.put(x, freq.get(x) - 1);
                need.put(x, need.get(x) - 1);
                need.put(x + 1, need.getOrDefault(x + 1, 0) + 1); // update the new need for next number
            } else if (freq.getOrDefault(x + 1, 0) > 0 &&
                    freq.getOrDefault(x + 2, 0) > 0) {
                // if there is no subseq need this, create a new 
                // we directly form x, x+1, x+2
                freq.put(x, freq.get(x) - 1);
                freq.put(x + 1, freq.get(x + 1) - 1);
                freq.put(x + 2, freq.get(x + 2) - 1);
                need.put(x + 3, need.getOrDefault(x + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
