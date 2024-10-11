// Hard
// BFS, Set
// O(m * n)
// https://leetcode.cn/problems/word-ladder/

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        // base case: if wordList did not included endWord -> return 0
        if (!set.contains(endWord)) {
            return 0;
        }
        
        // Queue -> use for BFS and record the words and the level we walk through
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);

        // Set -> use for mark as visited
        Set<String> vis = new HashSet<>();
        vis.add(beginWord);

        int level = 1;

        while (!que.isEmpty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                String curWord = que.poll();

                // iterate the curWord
                char[] curWordChar = curWord.toCharArray();
                for (int j = 0; j < curWordChar.length; j++) {
                    char oldWord = curWordChar[j]; // before replace with others char, need to store the original one

                    // Try all possibilities of char to replace
                    for (char c = 'a'; c <= 'z'; c++) {
                        curWordChar[j] = c;
                        // Get the newWord which replaced already
                        String newWord = new String(curWordChar);

                        // check if this word is matched with endWord(target word)
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // check if newWord in the wordlist set and did not vis
                        // then add newWord to queue and mark as vis
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
