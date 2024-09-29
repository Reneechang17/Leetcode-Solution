// Easy
// Hash Table, Array
// O(n)
// https://leetcode.cn/problems/contains-duplicate-ii/

import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // key為元素，value為索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //  如果已經存在這個數組，計算他們的距離滿足條件（小於等於k）
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // 如果不存在就放在map裡
            map.put(nums[i], i);
        }
        return false;
    }
}

/**
 * 存在重複元素II: 判斷一個數組中是否存在兩個不同索引i和j，nums[i] == nums[j]，兩者索引之間差的絕對值小於等於k
 * 思路：可以用哈希表紀錄每個元素最後一次出現的索引，對於每個元素，檢查是否存在另一個相同的元素，其差值不超過k
 **/