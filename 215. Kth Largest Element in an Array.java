// Medium
// QuickSelect
// O(n)
// https://leetcode.cn/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 找第k個大的元素，相當於是找第n-k個小的元素
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int splitIndex = (left + right) >> 1;
        int split = nums[splitIndex];
        int i = left, j = right;

        while (i <= j) {
            while (nums[i] < split) {
                i++;
            }
            while (nums[j] > split) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // 遞歸
        if (k <= j) {
            return quickSelect(nums, left, j, k);
        }
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