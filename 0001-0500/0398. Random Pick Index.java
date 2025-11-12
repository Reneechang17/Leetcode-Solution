// Medium
// HashMap, Random
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/random-pick-index/

import java.util.*;

class Solution {
    // (num, its appear indexs)
    private Map<Integer, List<Integer>> map;
    private Random random;

    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
