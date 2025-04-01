// Medium
// Hash Table, Counting
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/find-players-with-zero-or-one-losses/

import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>(); // loser count
        Set<Integer> winners = new HashSet<>();

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            winners.add(winner);
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }

        List<Integer> noLoss = new ArrayList<>(), oneLoss = new ArrayList<>();
        for (int w : winners) {
            if (!map.containsKey(w)) {
                noLoss.add(w);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                oneLoss.add(e.getKey());
            }
        }

        // sort result lists
        Collections.sort(noLoss);
        Collections.sort(oneLoss);
        return Arrays.asList(noLoss, oneLoss);
    }
}
