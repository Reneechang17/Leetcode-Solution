// Medium
// Binary Search
// O(logn)
// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // O(logn) -> binary search
        int[] res = new int[]{-1, -1};
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst (int[] nums, int target) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                // mid==target的條件寫在裡面是因為要找第一個位置 
                // 要確保搜索區間會繼續向左邊移動
                if (nums[mid] == target) index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    private int findLast (int[] nums, int target) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                // 同理，因為要找最後面的位置，所以mid==target的條件要在裡面判斷
                // 以確保搜索區間往右邊移動
                if (nums[mid] == target) index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
