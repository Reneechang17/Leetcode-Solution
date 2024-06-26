// Easy
// Array, Hash Table
// O(m + n)
// https://leetcode.com/problems/find-the-difference-of-two-arrays/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = convert(nums1);
        Set<Integer> s2 = convert(nums2);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int e : s1) {
            if (!s2.contains(e)) {
                list1.add(e);
            }
        }
        for (int e : s2) {
            if (!s1.contains(e)) {
                list2.add(e);
            }
        }
        return List.of(list1, list2);
    }

    private Set<Integer> convert(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int e : nums) {
            s.add(e);
        }
        return s;
    }
}

/**
 * 直接用set去重然後遍歷找不在的，如果不在就加入res List中
 **/