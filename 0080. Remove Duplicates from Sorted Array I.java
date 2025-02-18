// Medium
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
    // Use two pointers to remove duplicate in-place
    // Pointer i track of the position to overwrite, pointer j iterates through the array
    // Compare nums[j] with nums[i - 1], if different, overwrite nums[i + 1] and move i
    public int removeDuplicates(int[] nums) {
        // basecase: Array with <= 2 elements are valid
        if (nums.length <= 2) return nums.length;
        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
