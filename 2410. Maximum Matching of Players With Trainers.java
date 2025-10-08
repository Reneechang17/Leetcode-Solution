// Medium
// Greedy, Two Pointers
// Time:O(nlogn), Space:O(1)
// https://leetcode.cn/problems/maximum-matching-of-players-with-trainers/

// Why Medium..................??????????

import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0;
        int matches = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
            }
            j++; // cuz we have already sorted
        }
        return matches;
    }
}
