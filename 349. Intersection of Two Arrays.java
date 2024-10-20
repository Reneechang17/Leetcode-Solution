// Easy
// Hash Set, Array
// O(n)
// https://leetcode.cn/problems/intersection-of-two-arrays/

import java.util.*;

class Solution {
    // 找兩個數組的交集元素，可以用set來找重複的元素
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> inter = new ArrayList<>();
        
        // 先把nums1元素都放入set中
        for (int n : nums1) {
            set.add(n);
        }

        // 遍歷nums2，如果這個元素在set出現過，但還沒在裝交集元素的list中出現過
        // 則放入list中
        for (int n : nums2) {
            if (set.contains(n) && !inter.contains(n)) {
                inter.add(n);
            }
        }

        // 因為返回是int[]，遍歷一次list將元素複製到int[]中
        int[] res = new int[inter.size()];
        for (int i = 0; i < inter.size(); i++) {
            res[i] = inter.get(i);
        }
        return res;
    }
}

// 也可以直接用兩個count數組來做，分別紀錄兩個數組元素出現的次數
