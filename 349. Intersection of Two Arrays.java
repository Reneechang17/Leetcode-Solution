// Easy
// Array
// O(m + n)
// https://leetcode.cn/problems/intersection-of-two-arrays/

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] count1 = new int[1001];
        int[] count2 = new int[1001];

        for (int num : nums1) {
            count1[num]++;
        }
        for (int num : nums2) {
            count2[num]++;
        }

        List<Integer> intersections = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (count1[i] > 0 && count2[i] > 0) {
                intersections.add(i);
            }
        }

        int index = 0;
        int[] res = new int[intersections.size()];
        for (int i : intersections) {
            res[index] = i;
            index++;
        }
        return res;
    }
}

/**
 * 思路：
 * 1. 遍歷nums1 和 nums2，統計每個元素出現的次數
 * 2. 如果同一個數字在兩個數組中都至少出現一次，就加入列表中
 * 3. 定義最終res數組，遍歷res，將遍歷到的i賦值到res數組的index中
 **/