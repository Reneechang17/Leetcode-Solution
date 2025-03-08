// Medium
// DFS, Backtracking, HashMap
// Time:O(2^n),Space:O(n)
// https://leetcode.cn/problems/the-number-of-beautiful-subsets/

import java.util.*;

class Solution {
    // Backtracking or DFS:DFS to recursively consider included/excluded each element
    // Use HashMap to track freq of element already included in subset
    //  - for each element, ensure it doesn't create a subset that 2 element's absolute diff is k
    private int res = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public int beautifulSubsets(int[] nums, int k) {
        dfs(nums, k, 0); // search from index 0
        return res - 1; // excluded empty list
    }

    private void dfs(int[] nums, int k, int i) {
        if (i == nums.length) {
            res++;
            return;
        }
        dfs(nums, k, i + 1); // excluded cur element

        // if included, check diff
        if (map.getOrDefault(nums[i] - k, 0) == 0 && map.getOrDefault(nums[i] + k, 0) == 0) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); // add in
            dfs(nums, k, i + 1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) - 1); // backtracking: remove
        }
    }
}
