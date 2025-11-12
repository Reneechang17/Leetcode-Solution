// Medium
// Binary Search, Two Pointers
// Time:O(logn+k), Space:O(k)
// https://leetcode.cn/problems/find-k-closest-elements/

import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 二分找x的插入点
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] <= x) {
                left = mid + 1;
            } else { 
                right = mid - 1;
            }
        }

        // 初始化双指针，找到k个元素
        int low = left - 1, high = left;
        while (k > 0) {
            if (low < 0) { // 左边超界 -> 取右边
                high++;
            } else if (high >= arr.length) { // 右边超界 -> 取左边
                low--;
            } else if (Math.abs(arr[low] - x) <= Math.abs(arr[high] - x)) {
                low--; // 左边更近
            } else {
                high++; // 右边更近
            }
            k--;
        }

        // 把窗口内元素装到res里
        List<Integer> res = new ArrayList<>();
        for (int i = low + 1; i < high; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
