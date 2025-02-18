// Medium
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/gas-station/

class Solution {
    // Maintain total to check if the circuit is possible
    // Use cur to track current gas 
    //  - update start point if cur< 0, as it implies we can't start from the cur station
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // total means the total gas, cur means the cur gas
        // start means the cur start index
        int total = 0, cur = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            // if cur < 0, means we cannot reach the 
            // destination from this index
            if (cur < 0) {
                // update the start to next
                start = i + 1;
                cur = 0; // set cur as zero
            }
        }
        return total >= 0 ? start : -1;
    }
}
