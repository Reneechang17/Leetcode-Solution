// Medium
// HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/find-all-lonely-numbers-in-the-array/

import java.util.*;

class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int x = e.getKey();
            if (map.get(x) == 1 &&
                    !map.containsKey(x - 1) &&
                    !map.containsKey(x + 1)) {
                res.add(x);
            }
        }
        return res;
    }
}
