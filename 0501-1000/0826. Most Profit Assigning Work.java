// Medium
// Sorting, Greedy
// Time:O(nlogn), Space:O(1)
// https://leetcode.cn/problems/most-profit-assigning-work/

import java.util.Arrays;

class Solution {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int n = difficulty.length;

		// Sort the job by difficulty
		int[][] jobs = new int[n][2];
		for (int i = 0; i < n; i++) {
			jobs[i] = new int[] { difficulty[i], profit[i] };
		}
		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			maxProfit = Math.max(maxProfit, jobs[i][1]);
			jobs[i][1] = maxProfit;
		}

		// Sort by worker, we want every worker do their best to earn the most amount
		Arrays.sort(worker);

		int res = 0, jobIdx = 0;

		for (int ability : worker) {
			while (jobIdx < n && jobs[jobIdx][0] <= ability) {
				jobIdx++;
			}

			if (jobIdx > 0) {
				res += jobs[jobIdx - 1][1];
			}
		}
		return res;
	}
}
