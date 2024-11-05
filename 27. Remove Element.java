// Easy
// Two Pointers
// O(n)
// https://leetcode.cn/problems/remove-element/

class Solution {
    // return the number of element that not equal to val
    // we can use two pointers, one is go through the array, and check if it is equal to val
    // if not equal to val, then we fill it with another pointer
    public int removeElement(int[] nums, int val) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            } 
        }
        return slow;
    }
}
