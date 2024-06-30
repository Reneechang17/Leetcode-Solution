// Medium
// Array, Hash Table, Prefix Sum
// O(n)
// https://leetcode.com/problems/sum-of-distances/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[nums.length];
        for (List<Integer> indices : indexMap.values()) {
            long[] prefixSum = new long[indices.size()];
            long[] suffixSum = new long[indices.size()];
            // calculate prefix sum
            for (int i = 1; i < indices.size(); i++) {
                prefixSum[i] = prefixSum[i - 1] + (indices.get(i) - indices.get(i - 1)) * i;
            }
            // calculate suffix sum
            for (int i = indices.size() - 2; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + (indices.get(i + 1) - indices.get(i)) * (indices.size() - 1 - i);
            }
            for (int i = 0; i < indices.size(); i++) {
                ans[indices.get(i)] = (i > 0 ? prefixSum[i] : 0) + (i < indices.size() - 1 ? suffixSum[i] : 0);
            }
        }
        return ans;
    }
}

/**
 * 這題是計算數組中每個元素到所有其他相同值元素的距離和
 * 思路：前綴和+哈希表
 * 
 * 1. 用哈希表存儲這個元素出現的所有索引（方便之後計算距離）
 *    key是元素的值，value是這個元素出現所有索引的列表
 * 2. 初始化答案數組 & 前後綴和
 * 3. 分別計算前後綴和
 *    前綴和：對於每一個i，他的前綴和是前一個前綴和加上當前位置與前一個位置的差 乘以1
 *    後綴和：從數組的倒數第二個元素向前計算後綴和
 **/