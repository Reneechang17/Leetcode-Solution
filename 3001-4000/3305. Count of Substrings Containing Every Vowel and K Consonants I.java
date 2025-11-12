// Medium
// Sliding Window, Hash Table
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/

import java.util.Arrays;

class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length(), res = 0, count = 0;
        int[] vowels = new int[5];

        for (int left = 0; left < n; left++) {
            // 重置每次左指针移动时的计数器
            Arrays.fill(vowels, 0);
            count = 0;
            for (int right = left; right < n; right++) {
                char c = word.charAt(right);
                if (isVowel(c)) {
                    vowels[getVowelIndex(c)]++;
                } else {
                    count++;
                }
                // 判断当前的窗口是否符合条件
                if (allVowels(vowels) && count == k) {
                    res++;
                }
            }
        }
        return res;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    private int getVowelIndex(char c) {
        switch (c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }
    private boolean allVowels(int[] vowels) {
        for (int cnt : vowels) {
            if (cnt == 0) return false;
        }
        return true;
    }
}
