// Medium
// Array, Two Pointers
// O(N)
// https://leetcode.cn/problems/next-permutation/

class Solution {
    public void nextPermutation(int[] nums) {
        // 從後向前遍歷
        // 因為需要比較nums[i]和nums[i+1]，所以i從倒數第二個開始，這樣nums[i+1]就是數組最後一個元素
        int i = nums.length - 2;

        // 找第一個升序對即nums[i] >= nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            // 從後往前找到第一個比nums[i]大的數nums[j]
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 雙指針反轉數組
    private void reverse (int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap (nums, start, end);
            start++;
            end--;
        }
    }
}

/**
 * 這題是下一個排列，要求找到給定數字序列的下一個字典序更大的排列。如果不存在更大的排列，即數組是降序的，則將數字重新排列成升序
 * 
 * 思路：先從後往前查找，找到第一對連續的數字nums[i]和nums[i+1],其中nums[i]<nums[i+1], 表明序列nums[i+1]到nums[n-1]是降序的
 * 如果找到i，再次從後往前找到第一個比nums[i]大的數nums[j]，因為nums[i+1]到nums[n-1]是降序的，所以j會是這個範圍內最小的一個可以使得排列更大的交換選擇
 * 再將nums[i]和nums[j]交換
 * 將nums[i+1]到nums[n-1]的序列反轉，使其成為升序，因為原本是降序，反轉後就會變成升序，這樣可以保證得到的新序列是所有大於原序列的排列中最小的一個
 **/