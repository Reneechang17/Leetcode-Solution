// Easy
// Array
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/

import java.util.*;

// TODO: find a way to explain set idea.....:>
class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (x > 0) set.add(x);
        }
        return set.size();
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 5, 0, 3, 5};
        System.out.println(sol.minimumOperations(nums1)); // expected:3
        
        int[] nums2 = {0, 0, 0, 0};
        System.out.println(sol.minimumOperations(nums2)); // expected:0
    }
}
