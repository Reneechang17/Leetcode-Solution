// Medium
// HashMap
// https://leetcode.cn/problems/finding-pairs-with-a-certain-sum/

import java.util.*;

class FindSumPairs {
    private int[] nums1, nums2;
    private Map<Integer, Integer> cnt; 

    // Time: O(n), Space: O(n)
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.cnt = new HashMap<>();
        
        for (int num : nums2) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
    }
    
    // Time: O(1), Space: O(1)
    public void add(int index, int val) {
        int oldValue = nums2[index];
        int newValue = oldValue + val;

        // update HashMap
        cnt.put(oldValue, cnt.get(oldValue) - 1);
        if (cnt.get(oldValue) == 0) {
            cnt.remove(oldValue);
        }

        cnt.put(newValue, cnt.getOrDefault(newValue, 0) + 1);
        nums2[index] = newValue;
    }
    
    // Time: O(n), Space: O(1)
    public int count(int tot) {
        int res = 0;
        for (int num : nums1) {
            int target = tot - num;
            if (cnt.containsKey(target)) {
                res += cnt.get(target);
            }
        }
        return res;
    }
}
