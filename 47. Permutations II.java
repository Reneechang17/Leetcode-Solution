// Medium
// Backtracking
// Time:O(n!),Space:O(n)(if add res space -> O(n!)
// https://leetcode.cn/problems/permutations-ii/

import java.util.*;
class Solution {
    // Use backtrack to find all unique permutations, first sort arr to handle duplicate
    // Use a used arr to mark elements in current path, and skip duplicate elements in 
    //   - the same recursion level to avoid redundant permutations
    // Restore state after recursion (backtracking) to explore other possibilities

    boolean[] used;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        check(nums, used);
        return res;
    }
    private void check(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // skip duplicate in the same recursion level
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // only the element didn't use can be picked
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                check(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}

// duplicate idea
//  - i > 0 to make sure nums[i-1] exist
//  - nums[i] == nums[i - 1] means cur and prev are same
//  - !used[i - 1] means prev didn't use in cur recusrion
//    - Indicates prev has been backtracked and 
//    - removed while constructing cur permutation
