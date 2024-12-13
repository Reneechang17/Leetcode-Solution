// Medium
// Binary Search
// Time:O(n logn), Space:O(1)
// https://leetcode.cn/problems/find-the-duplicate-number/

class Solution {
    // Since we need SpaceO(1), means we cannot use data structure
    // We can use two pointers to check, which will be O(n)
    //   - can also use Binary Search instead of iterating whole arr
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            // calculate the numbers smaller than mid
            for (int x : nums) {
                if (x <= mid)
                    count++;
            }
            // if the elements smaller than mid > bigger than mid
            // means this duplicate number on left side
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

class Solution2 {
    // Time: O(n), Space: O(1)
    // Use two pointers (slow and fast) to detect the cycle in the array
    // Find the intersection point of the two pointers
    // Use another pointer to find the entrance of the cycle, which is the 
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
