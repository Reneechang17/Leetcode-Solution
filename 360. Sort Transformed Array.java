// Medium
// Math, Array, Two Pointers
// O(n)

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int left = 0, right = n - 1;
        int index = a >= 0 ? n - 1 : 0;

        while (left <= right) {
            int leftVal = transform(nums[left], a, b, c);
            int rightVal = transform(nums[right], a, b, c);
            // 'a' can determine whether the parabola is going up or down.
            if (a >= 0) {
                // if the parabola opens upwards, start filling from the end of the array.
                if (leftVal >= rightVal) {
                    sorted[index--] = leftVal;
                    left++;
                } else {
                    sorted[index--] = rightVal;
                    right--;
                }
                // otherwise, start filling from the start of the array
            } else {
                if (leftVal <= rightVal) {
                    sorted[index++] = leftVal;
                    left++;
                } else {
                    sorted[index++] = rightVal;
                    right--;
                }
            }
        }
        return sorted;
    }

    private int transform(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
