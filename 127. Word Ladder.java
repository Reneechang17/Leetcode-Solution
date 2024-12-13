// Hard
// BFS, Set
// Time:O(N*L), Space:O(N*L)
// N is the number of words in the wordList, L is the average length of a word
// https://leetcode.cn/problems/word-ladder/

import java.util.*;

class Solution {
    // Use BFS to find the shortest transformation sequence from beginWord to endWord
    // At each step, generate all possible one-char transformation of the cur word
    // If a transformation matches endWord, return cur level + 1
    // Use a set to track visited words and prevent revisiting. If endWord isn't in wordList, return 0
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        // basecase: if endWord is not in wordList, return 0
        if (!set.contains(endWord)) return 0;

        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        Set<String> vis = new HashSet<>(); // use for mark as vis
        vis.add(beginWord);
        int level = 1;
        
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                String curWord = que.poll();
                // iterate each char in curWord
                char[] curWordChar = curWord.toCharArray();
                for (int j = 0; j < curWordChar.length; j++) {
                    char oldWord = curWordChar[j]; 
                    // try all possible char to replace
                    for (char c = 'a'; c <= 'z'; c++) {
                        curWordChar[j] = c;
                        // get the new word
                        String newWord = new String(curWordChar);
                        // check if this newWord matches with endWord
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        // check if newWord in the wordList and did not vis
                        // if so, add newWord to queue and mark as vis
                        if (set.contains(newWord) && !vis.contains(newWord)) {
                            que.offer(newWord);
                            vis.add(newWord);
                        }
                    }
                    curWordChar[j] = oldWord; // set back
                }
            }
            level++;
        }
        return 0;
    }
}
