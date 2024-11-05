// Easy
// Two Pointers
// O(n)
// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/

class Solution {
    // since the given array is sorted, we just need to make sure 
    // that the next one is not same as prev one
    // no need for check basecase since the length of nums will not be 0
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
