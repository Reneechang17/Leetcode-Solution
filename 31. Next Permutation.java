// Medium
// Array, Two Pointers
// O(n)
// https://leetcode.cn/problems/next-permutation/

class Solution {
    // 下一個排列，這題有三步
    // 1. 從後向前遍歷找第一組nums[i]<nums[i+1] -> nums[i+1]-nums[n-1]是降序的
    // 2. 如果找到i，再從後向前找第一個大於nums[i]的數nums[j]，交換他們
    // 3. 將nums[i+1]-nums[n-1]反轉，這樣可以保證得到的新序列是所有大於原序列的排列中最小的
    public void nextPermutation(int[] nums) {
        // 因為要比較nums[i]和nums[i+1]，i從倒數第二個遍歷
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

/**
 * 1. 後往前查找，找到第一對連續的數字nums[i]和nums[i+1],其中nums[i]<nums[i+1], 表明序列nums[i+1]到nums[n-1]是降序的
 * 2. 如果找到i，再次從後往前找到第一個比nums[i]大的數nums[j]，因為nums[i+1]到nums[n-1]是降序的，所以j會是這個範圍內最小的一個可以使得排列更大的交換選擇，將nums[i]和nums[j]交換
 * 3. 將nums[i+1]到nums[n-1]的序列反轉，原本是降序，反轉後就會變成升序，保證得到的新序列是所有大於原序列的排列中最小的一個
 **/
