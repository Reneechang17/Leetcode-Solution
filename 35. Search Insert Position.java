// Easy
// Binary Search
// Time: O(logn), Space: O(1)
// https://leetcode.cn/problems/search-insert-position/

class Solution {
    // The left pointer will stop at the target position if the target exists in the arr;
    // if target is not in the arr, the left pointer will stop at the position where the target should be inserted
    // since right = mid - 1, left will always point to the next possible position
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

// dryrun
// nums=[1,3,5,6], t=5
// init: left=0, right=3

// start the while loop:
// left=0, right=3, mid=(0+3)>>1=1
// nums[mid]=3, since 3<5 => left=1+1=2

// next iteration:
// left=2, right=3, mid=(2+3)>>1=2
// nums[mid]=5, since 5>=5(t) => right=2-1

// Loop ends: left=2, right=1
// return left=2, which is the correct index of target=5 in nums
