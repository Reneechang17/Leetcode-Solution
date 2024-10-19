// Medium
// QuickSelect
// O(n)
// https://leetcode.cn/problems/kth-largest-element-in-an-array/

class Solution {
    // 找第k個大的元素 -> 找第n-k個小的元素
    // 快排：將數組分成兩部分，一部分都比pivot大，一部分都比pivot小
    // 透過遞歸縮小搜索範圍
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[(left + right) >> 1];
        int i = left, j = right;

        // 將數組分成兩個部分
        while (i <= j) {
            // 移動i，找到第一個大於等於pivot的值
            while (nums[i] < pivot) {
                i++;
            }
            // 移動j，找到第一個小於等於pivot的值
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // 縮小遞歸的範圍，如果k在左邊
        if (k <= j) {
            return quickSelect(nums, left, j, k);
        }
        // 如果k在右邊
        if (k >= i) {
            return quickSelect(nums, i, right, k);
        }
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * 數組中第k大的元素
 * 這題是找第k個最大元素，那反過來就是第nums.length - k 個最小元素
 * 
 * 這題可以用快排來做，核心是通過partition將數組分成兩個部分，一部分的所有元素都大於某個pivot，另一部分的所有元素都小於pivot，然後遞歸縮小搜索範圍，直到找到第k大的元素
 * 本題中我們現在數組中選擇一個元素（這裡是split），將數組劃分成兩部分，再通過雙指針法，將比split小的元素放在左邊，比split大的元素放在右邊，當i<= j時，交換nums[i]和nums[j]，然後i++，j--
 * 
 * 如果k<=j 則比k大的元素在左半邊，遞歸左半邊
 * 如果k>=i 則比k大的元素在右半邊，遞歸右半邊
 **/
