// Easy
// Binary Search
// Time:O(log n), Space:O(1)
// https://leetcode.cn/problems/binary-search/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

// nums = [-1,0,3,5,9,12], target = 9
// left = 0, right = 5
// mid = (0+5)/2 = 2
// nums[2] = 3
// 3 < 9 -> left = mid+1= 3
// [5,9,12]

// mid = (3+5)/2=4
// nums[4]=9
// 9 == 9 -> return 4
