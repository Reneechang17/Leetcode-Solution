// Medium
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/best-sightseeing-pair/

class Solution {
	public int maxScoreSightseeingPair(int[] values) {
		int maxScore = 0;
		int best = values[0];

		for (int j = 1; j < values.length; j++) {
			int curScore = best - 1 + values[j];
			maxScore = Math.max(maxScore, curScore);

			best = Math.max(best - 1, values[j]);
		}
		return maxScore;
	}
}
