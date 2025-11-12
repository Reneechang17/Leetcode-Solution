// Medium
// Graph
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/percentage-of-letter-in-string/

// Interesting, I think it could be easy :D

class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];

        for (int src = 0; src < n; src++) {
            int dest = edges[src];
            score[dest] += src;
        }

        int maxNode = 0;
        long maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                maxNode = i;
            }
        }
        return maxNode;
    }
}
