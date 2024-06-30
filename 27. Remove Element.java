// Easy
// Array, Two Pointers
// O(n)
// https://leetcode.com/problems/remove-element/

class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;

        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}

/**
 * 思路：快慢指針解決
 * 都從數組的開頭位置出發，用快指針去遍歷數組
 * 如果快指針沒有遇到val，則將快指針的值賦值給慢指針，慢指針++
 * 如果遇到，就直接走，最後返回慢指針
 **/