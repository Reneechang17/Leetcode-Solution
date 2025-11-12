// Medium
// Simulation, Greedy
// Time:O(√numBottles), Space:O(n)
// https://leetcode.cn/problems/water-bottles-ii/

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = numBottles, empty = numBottles;

        while (empty >= numExchange) {
            empty -= numExchange;
            drunk++;
            empty++;
            numExchange++;
        }
        return drunk;
    }
}
