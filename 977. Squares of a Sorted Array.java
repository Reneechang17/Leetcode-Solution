// Easy
// Array, Two Pointers, Sorting
// O(n)

class Solution {
    public int[] sortedSquares(int[] nums) {
        // define two pointers at the start and end of array
        int i = 0, j = nums.length - 1;
        // define a res array
        int[] res = new int[nums.length];
        // define a pointer start from the end of res array
        int k = nums.length - 1;
        // when i<=j, if i^2 < j^2, the k will fill j, otherwise, the k fill i
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[k--] = nums[j] * nums[j];
                j--;
            } else {
                res[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }
}
