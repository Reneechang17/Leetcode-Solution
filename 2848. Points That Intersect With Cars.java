// Easy
// Array, Sorting
// Time:O(nlogn), Space:O(nlogn)
// https://leetcode.cn/problems/points-that-intersect-with-cars/

import java.util.*;

class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, (a, b) -> a.get(0) - b.get(0));

        int cnt = 0, curEnd = 0;
        for (List<Integer> car : nums) {
            int start = car.get(0), end = car.get(1);

            if (start > curEnd) {
                cnt += end - start + 1;
                curEnd = end;
            } else if (end > curEnd) {
                cnt += end - curEnd;
                curEnd = end;
            }
        }
        return cnt;
    }
}
