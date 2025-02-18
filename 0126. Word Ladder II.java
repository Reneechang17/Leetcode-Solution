// Hard
// BFS, DFS, Hash Table
// O(m * n)
// https://leetcode.cn/problems/word-ladder/

import java.util.*;

class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> res = new ArrayList<>();
      Set<String> set = new HashSet<>(wordList);

      if (!set.contains(endWord)) return res;

      // BFS：訪問所有可能的單詞變化，紀錄某個單詞到其他單詞的路徑，構成圖
      // 也就是紀錄到達某個單詞的路徑
      Map<String, List<String>> graph = new HashMap<>();
      Map<String, Integer> dis = new HashMap<>();
      bfs(beginWord, endWord, set, graph, dis);

      // DFS：從終點單詞反向構建出所有最短路徑
      List<String> path = new ArrayList<>();
      path.add(endWord);
      dfs(res, graph, dis, endWord, beginWord, path);
      return res;
  }

  private void bfs (String beginWord, String endWord, Set<String> set, Map<String, List<String>> graph, Map<String, Integer> dis) {
      Queue<String> que = new LinkedList<>();
      que.offer(beginWord);
      dis.put(beginWord, 0);
      
      while (!que.isEmpty()) {
          String curWord = que.poll();
          int curDis = dis.get(curWord);

          List<String> nextWords = getNextWords(curWord, set);
          for (String next : nextWords) {
              if (!dis.containsKey(next)) {
                  dis.put(next, curDis + 1);
                  que.offer(next);
              }
              graph.putIfAbsent(next, new ArrayList<>());
              graph.get(next).add(curWord);
          }
      }
  }
  // 獲取與當前單詞相差一個字母的所有單詞
  private List<String> getNextWords(String word, Set<String> set) {
      List<String> nextWords = new ArrayList<>();
      char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; i++) {
          char oldChar = chars[i];
          for (char c = 'a'; c <= 'z'; c++) {
              if (c == oldChar) continue;
              chars[i] = c;
              String newWord = new String(chars);
              if (set.contains(newWord)) {
                  nextWords.add(newWord);
              }
          }
          chars[i] = oldChar;
      }
      return nextWords;
  }

  private void dfs(List<List<String>> res, Map<String, List<String>> graph, Map<String, Integer> dis, String curWord, String beginWord, List<String> path) {
      if(curWord.equals(beginWord)) {
          List<String> solutions = new ArrayList<>(path);
          Collections.reverse(solutions); // 因為我們從endWord回溯到beginWord
          res.add(solutions);
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
