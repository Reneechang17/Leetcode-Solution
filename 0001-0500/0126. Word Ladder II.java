// Hard
// BFS, DFS, 
// Time:O(n*m),Space:O(n*m)
// https://leetcode.cn/problems/word-ladder/

import java.util.*;
class Solution {
    // BFS to find shortest path from beginWord to endWord
    // DFS to do backtracking from endWord back to beginWord
    public  List<List<String>>findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // store the words in wordList
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return res;

        // BFS to record the path from A word to B word
        // represent a graph where each word maps to a list of words 
        // that can be reached by changing one letter at a time
        Map<String, List<String>> graph = new HashMap<>();
        // stroe the shortest distance from beginWord to each word
        Map<String, Integer> dis = new HashMap<>();
        bfs(beginWord, endWord, set, graph, dis);
        
        // DFS to find all shortest paths from endWord to beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(res, graph, dis, endWord, beginWord, path);
        
        return res;
    }
    private void bfs(String beginWord, String endWord, Set<String> set, Map<String, List<String>> graph, Map<String, Integer> dis) {
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        dis.put(beginWord, 0);
        while (!que.isEmpty()) {
            String curWord = que.poll();
            int curDis = dis.get(curWord);
            List<String> nexts = getNextWords(curWord, set);
            for (String next : nexts) {
                if (!dis.containsKey(next)) {
                    dis.put(next, curDis + 1);
                    que.offer(next);
                }
                graph.putIfAbsent(next, new ArrayList<>());
                graph.get(next).add(curWord);
            }
        }
    }
    // get all words that differ by one letter
    private List<String> getNextWords(String word, Set<String> set) {
        List<String> nexts = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (set.contains(newWord)) {
                    nexts.add(newWord);
                }
            }
            chars[i] = oldChar;
        }
        return nexts;
    }
    private void dfs(List<List<String>> res, Map<String, List<String>> graph, Map<String, Integer> dis, String curWord, String beginWord, List<String> path) {
        if (curWord.equals(beginWord)) {
            List<String> list = new ArrayList<>(path);
            Collections.reverse(list);
            res.add(list);
            return;
        }
        for (String pre : graph.getOrDefault(curWord, new ArrayList<>())) {
            if (dis.get(pre) == dis.get(curWord) - 1) {
                path.add(pre);
                dfs(res, graph, dis, pre, beginWord, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
