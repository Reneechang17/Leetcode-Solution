// Medium
// Array
// O(n) 
// https://leetcode.cn/problems/shortest-word-distance-iii/

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1, index2 = -1, minDis = wordsDict.length;
        // 這題允許word1和word2相同，所以要先檢查word1和word2是否相同
        // 分別處理word1和word2相同和不同的情況
        boolean same = word1.equals(word2);

        for (int i = 0; i < wordsDict.length; i++) {
            // word1和word2相同
            if (same && wordsDict[i].equals(word1)) {
                // 先檢查index1是否被更新過
                if (index1 != -1) {
                    minDis = Math.min(minDis, i - index1);
                }
                // 如果沒有被更新過，先更新index1
                index1 = i;
            // word1和word2不相同
            } else {
                if (wordsDict[i].equals(word1)) {
                    index1 = i;
                    if (index2 != -1) {
                        minDis = Math.min(minDis, Math.abs(index1 - index2));
                    }
                }
                if (wordsDict[i].equals(word2)) {
                    index2 = i;
                    if (index1 != -1) {
                        minDis = Math.min(minDis, Math.abs(index1 - index2));
                    }
                }
            }
        }
        return minDis;
    }
}
