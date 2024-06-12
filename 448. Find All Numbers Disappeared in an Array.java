// Easy
// Array
// O(n)
// Similar: 76,567
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        // calculate the times of each number in nums
        int[] count = new int[len + 1];
        for (int num : nums) {
            count[num]++;
        }
        // iterate the count array, if the number in count exist 0 time, means it no
        // exist and add it to res
        List<Integer> res = new LinkedList<>();
        for (int num = 1; num <= len; num++) {
            if (count[num] == 0) {
                res.add(num);
            }
        }
        return res;
    }
}

/**
 * 思路：用count數組統計每一個元素數字出現的次數
 * 再遍歷count，找count[num]=0的
 **/