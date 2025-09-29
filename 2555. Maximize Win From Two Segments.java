// Medium
// Sliding Window
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/maximize-win-from-two-segments/

// Honestly I tried to understand wtf of this question for like 40 mins but still no any idea:D
// Probably I'm stupid

class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        // max prizes that prior i's using same seg
        int[] maxPrize = new int[n + 1];
        int max = 0;

        // AI taught me using sliding window and as a coachable user, I did:D
        // But actually this makes sense to me
        int left = 0;
        for (int right = 0; right < n; right++) {
            // makes sure the window in the range <= k
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }

            // cur window's prize
            int curPrize = right - left + 1;

            // update best prefix val(fine I gave the name)
            maxPrize[right + 1] = Math.max(maxPrize[right], curPrize);

            // max is the second[left,right] + first best maxPrize[left] <-- this is abstract:D
            max = Math.max(max, curPrize + maxPrize[left]);
        }
        return max;
    }
}
