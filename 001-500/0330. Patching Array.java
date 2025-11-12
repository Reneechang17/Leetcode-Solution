// Hard
// Array, Greedy
// O(m + logn)
// https://leetcode.com/problems/patching-array/

class Solution {
    public int minPatches(int[] nums, int n) {
        long max = 0; // 用long避免int溢出（可以看用int跑出來的wrong）
        int ans = 0, i = 0;

        while (max < n) {
            if (i < nums.length && nums[i] <= max + 1) {
                max += nums[i];
                i++;
            } else {
                max += max + 1;
                ans++;
            }
        }
        return ans;
    }
}

// 題目給定一個數組和一個整數n，從[1, n]區間內選取任何一個數組添加 or補到數組中，使得[1, n]區間內的任何數字可以用數組中某幾個數字的和
/**
 * 思路：這題是一個莫名其妙的貪心
 * 
 * 具体例子：
 * 假设 max 当前是 3，这表示我们可以用数组中的数字组合覆盖从 1 到 3 的所有数字。如果数组中没有更小的数字可以直接覆盖 4，那么：
 * 
 * max + 1 就是 4（这是我们需要的下一个数字）。
 * 通过执行 max += max + 1，即 max += 4，更新后的 max 将变为 7。这意味着通过添加 4 到数组中，我们现在可以覆盖从 1 到 7
 * 的所有数字。
 * 这种策略是基于这样一个事实：每添加一个数字，我们都希望最大限度地扩展覆盖范围。通过添加 max +
 * 1，我们保证了覆盖范围以最大可能的方式增加，因为这个新添加的数字与之前可覆盖的所有数字组合都可能产生新的和，从而扩大覆盖范围。
 * 
 **/