// Medium
// Binary Search
// O(m*n+k*logk)
// https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/

import java.util.Arrays;

class Solution {
    // 1. 检查words中每个字符串的最小字母频次并排序 -> 此步可以抽取方法
    // 2. 遍历queries数组，用二分统计比f(queries[i])大的频次
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int[] res = new int[n];

        // 计算words数组中每个字符串的最小字母出现的频次
        int[] wordFreq = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordFreq[i] = f(words[i]);
        }
        Arrays.sort(wordFreq);

        // 遍历queries数组，对于每个queries，先计算每个字符串的最小字母出现的频次
        // 再用二分找比f(queries[i])大的频率个数
        for (int i = 0; i < queries.length; i++) {
            int queryFreq = f(queries[i]);
            res[i] = wordFreq.length - binarySearch(wordFreq, queryFreq);
        }
        return res;
    }

    private int f(String s) {
        char minChar = 'z';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
                count = 1;
            } else if (c == minChar){
                count++;
            }
        }
        return count;
    }

    // 找第一个比target大的索引
    private int binarySearch(int[] wordFreq, int target) {
        int left = 0, right = wordFreq.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (wordFreq[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
