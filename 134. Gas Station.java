// Medium
// Greedy
// O(n)
// https://leetcode.cn/problems/gas-station/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // total means the total gas
        // cur means the cur gas
        // start means the cur start index
        int total = 0, cur = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            // calculate the total and cur
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];

            // if cur is smaller than 0, means we cannot reached the 
            // destination from this index
            if (cur < 0) {
                // than we can update the gas station to next
                start = i + 1;
                cur = 0; // and set the cur as zero
            }
        }
        return total >= 0 ? start : -1;
    }
}
