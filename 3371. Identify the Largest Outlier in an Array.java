// Medium
// HashMap, Array
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/identify-the-largest-outlier-in-an-array/

import java.util.*;

class Solution {
    // Identify an outlier in the arr such that the rest of elements can be split into two equal part
    // Iterate the arr, we can assume each element as outlier, and if check if the remain part can be split into two
    // If so, we can calculate the specialSum by dividing the remain part with 2,
    // and check if the specialSum is valid
    public int getLargestOutlier(int[] nums) {
        int totalSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            totalSum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int largestOutlier = Integer.MIN_VALUE;
        for (int num : nums) {
            // 遍历数组，假设当前是异常值，剩下的sum应该可以分成两等份
            // 分别是特殊值自己和加起来和为特殊值的元素（们）
            int remainSum = totalSum - num;
            if (remainSum % 2 == 0) {
                // specialSum就是 特殊值和 一组和为特殊值的元素
                int specialSum = remainSum / 2;
                // totalSum = specialSum + outlier + sum(specialNumbers)
                // 我们要确保specialSum是数组中的一个数字，也就是必须在原数组中出现过
                // 同时这个specialSum如果和当前检查的num不相等，则直接认为是一个合法的情况
                // 如果specialSum == num，我们需要确定这个specialSum在数组中出现超过一次
                // 才可以保证specialSum和num是两个不同的数
                if (map.containsKey(specialSum) && (specialSum != num || map.get(specialSum) > 1)) {
                    largestOutlier = Math.max(largestOutlier, num);
                }
            }
        }
        return largestOutlier;
    }
}
