// Medium
// Binary Search, Two Pointers
// https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    // Two pointers would be straight
    // Time:O(n), Space:O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                // return 1-indexed index
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1}; // never execute this line
    }
}

class Solution2 {
    // Since the question states the input is "sorted" array
    // So we need to use this "character"(?) -> Binary search
    // Time:O(n logn), Space:O(1)
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            int x = target - numbers[i]; // we use binary search to find this x

            // use <= to cover the last element
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (numbers[mid] > x) {
                    right = mid - 1;
                } else if (numbers[mid] < x) {
                    left = mid + 1;
                } else {
                    // return 1-indexed index
                    return new int[] { i + 1, mid + 1 };
                }
            }
        }
        return new int[] { -1, -1 }; // never execute this line
    }
}
