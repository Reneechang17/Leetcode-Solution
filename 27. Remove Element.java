// Easy
// Array, Two Pointers
// O(n)

class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        // if fastIndex meet the val, it go first
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
