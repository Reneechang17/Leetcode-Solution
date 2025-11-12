// Easy
// Map
// Time: O(n), Space: O(n)
// https://leetcode.cn/problems/count-elements-with-maximum-frequency/

import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, cnt = 0;

        for (int x : nums) {
            int curFreq = map.getOrDefault(x, 0) + 1;
            map.put(x, curFreq);

            if (curFreq > max) {
                max = curFreq;
                cnt = curFreq;
            } else if (curFreq == max) {
                cnt += curFreq;
            }
        }
        return cnt;
    }
}
