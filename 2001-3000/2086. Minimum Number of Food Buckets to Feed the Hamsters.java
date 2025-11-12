// Medium
// Greedy
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/

class Solution {
    public int minimumBuckets(String hamsters) {
        if (hamsters.contains("HHH"))
            return -1;
        if (hamsters.startsWith("HH") || hamsters.endsWith("HH"))
            return -1;
        if (hamsters.equals("H"))
            return -1;
        
        int b = 0;
        char[] chars = hamsters.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'H') {
                // Greedy to put on the right side
                if (i + 1 < chars.length && chars[i + 1] == '.') {
                    chars[i + 1] = 'B';
                    b++;
                    i += 2;
                } else if (i > 0 && chars[i - 1] == '.') {
                    chars[i - 1] = 'B';
                    b++;
                }
            }
        }
        return b;
    }
}
