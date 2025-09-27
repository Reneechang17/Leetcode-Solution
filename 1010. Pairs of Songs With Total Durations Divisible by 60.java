// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/

// Brute force is easy to come out but it is obviouly only qualify for easy.
// The opt way is pretty like two sum but in array.

class Solution {
    // (a+b) % 60 == 0-> (a % 60) && (b % 60) == 0
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];
        int cnt = 0;

        for (int t : time) {
            int mod = t % 60;
            int target = (60 - mod) % 60;
            cnt += remainder[target];

            remainder[mod]++;
        }
        return cnt;
    }
}

// class Solution {
//     // Brute force-> Timeout
//     public int numPairsDivisibleBy60(int[] time) {
//         int cnt = 0, n = time.length;

//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if ((time[i] + time[j]) % 60 == 0) {
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }
