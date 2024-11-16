// Easy
// Hash Table
// O(N)
// https://leetcode.cn/problems/degree-of-an-array/

import java.util.*;

class Solution {
    // degree指的是数组中任意一个元素出现最高的频率，目標是找到與原數組具有相同度數的最短連續子數組
    // 一个哈希表储存每个元素出现的次数、一个哈希表存元素第一次和最后一次出现的位置
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(), first = new HashMap<>(), last = new HashMap<>();
        int res = Integer.MAX_VALUE, degree = 0;

        for (int i = 0; i < nums.length; i++) {
            // only if nums[i] is not in the map, we put it in the first map
            first.putIfAbsent(nums[i], i);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // keep updating the last map
            last.put(nums[i], i);
            degree = Math.max(degree, map.get(nums[i]));
        }

        for (int key : map.keySet()) {
            if (map.get(key) == degree) {
                res = Math.min(res, last.get(key) - first.get(key) + 1);
            }
        }
        return res;
    }
}
