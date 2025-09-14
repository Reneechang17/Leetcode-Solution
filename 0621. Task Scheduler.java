// Medium
// Math
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/task-scheduler/

// It actually is:
// example: tasks = [A,A,A,B,B,B], n = 2
// -> A _ _ A _ _ A 
// set B -> AB _ AB _ AB 
// -> ans = 8

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // count freq
        int[] freq = new int[26];
        int maxCnt = 0;

        for (char t : tasks) {
            freq[t - 'A']++;
            maxCnt = Math.max(maxCnt, freq[t - 'A']);
        }

        // the most freq one will give the structure like line 7
        int mostFreq = 0;
        for (int f : freq) {
            if (f == maxCnt)
                mostFreq++;
        }

        // calculate structure = (maxCnt-1) * (n+1) + mostFreq
        int size = (maxCnt - 1) * (n + 1) + mostFreq;

        return Math.max(size, tasks.length);
    }
}
