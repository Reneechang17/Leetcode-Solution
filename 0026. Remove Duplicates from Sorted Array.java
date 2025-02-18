// Easy
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/

class Solution {
    // Given array is sorted, only need to check if the next one is not same as prev one
    // no need for check basecase since the length of nums will not be 0
    public int removeDuplicates(int[] nums) {
        // j use to record the last index of the non-duplicate array
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            // put cur element to nums[j+1], and update j
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
