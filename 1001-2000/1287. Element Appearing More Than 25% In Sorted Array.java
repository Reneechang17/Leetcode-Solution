// Easy
// Map, Counting
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/

import java.util.*;
class Solution {
    public int findSpecialInteger(int[] arr) {
        int t = arr.length / 4;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
                if (map.get(x) > t) return x;
            }
        }
        return arr[0];
    }
}
