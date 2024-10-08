// Medium
// Binary Search
// O(logn)
// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

/**
 * 要求在一個沒有重複元素、部分旋轉的排序數組中找到最小元素，這個數組原本是升序的，然後在某個點上進行了旋轉
 * 可以觀察最小值出現的位置在部分升序後不正常的轉折點
 * 這題可以用二分查找來做，通過比較數組中間元素的右端點元素來判斷最小值在左半還是右半
 * 循環結束後，nums[left]就是最小值
 **/
