// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-distance-in-arrays/

import java.util.*;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // the thing is the biggest and smallest should from diff arr
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = 0;

        // start from second arr cuz we init the min/max val with first arr
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int curMin = arr.get(0);
            int curMax = arr.get(arr.size() - 1);

            maxDist = Math.max(maxDist, curMax - minVal);
            maxDist = Math.max(maxDist, maxVal - curMin);

            minVal = Math.min(minVal, curMin);
            maxVal = Math.max(maxVal, curMax);
        }
        return maxDist;
    }
}
