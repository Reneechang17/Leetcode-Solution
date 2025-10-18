// Medium
// Sorting, Map
// Time:O(n + mlogm), Space: O(m)
// https://leetcode.cn/problems/least-number-of-unique-integers-after-k-removals/

import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        int del = 0;
        for (int x : list) {
            if (k >= x) {
                k -= x;
                del++;
            } else {
                break;
            }
        }
        return map.size() - del;
    }
}
