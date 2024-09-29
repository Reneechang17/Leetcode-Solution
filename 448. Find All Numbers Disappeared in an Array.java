// Easy
// Array
// O(n)
// Similar: 76,567
// https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int[] count = new int[len + 1];

        for (int num : nums) {
            count[num]++;
        }

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
 * 再遍歷count，找count[num]=0的，表示這個元素沒有出現過
 **/