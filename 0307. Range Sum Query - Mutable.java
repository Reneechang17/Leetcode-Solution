// Medium
// Binary Indexed Tree
// Time:O(logn),Space:O(n)
// https://leetcode.cn/problems/range-sum-query-mutable/

class NumArray {
    // Use Binary Indexed Tree
    private int[] tree; // BIT to store prefix sum
    private int[] nums; // store the values in original array

    public NumArray(int[] nums) {
        this.tree = new int[nums.length + 1]; // 1-indexed
        this.nums = nums;
        // initialize the BIT with the values from original arr
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        // update BIT with the difference(val - cur val)
        add(index + 1, val - nums[index]);
        // update original arr
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        // get the sum in range [left, right]
        return prefixSum(right + 1) - prefixSum(left);
    }

    // Some helper functions
    private void add(int index, int val) {
        while (index < tree.length) {
            tree[index] += val;
            // move to the next index in tree
            index += lowBit(index);
        }
    }
    // lowBit use to calculate the lowest bit of an integer for BIT operations
    private int lowBit(int x) {
        return x & -x; // returns lowest bit using bitwise operation
    }
    // calculate the prefix sum from index 1 to the given index
    private int prefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lowBit(index); // move to parent index
        }
        return sum;
    }
}

