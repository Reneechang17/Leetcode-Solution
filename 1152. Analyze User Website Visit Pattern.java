// Medium
// https://leetcode.cn/problems/analyze-user-website-visit-pattern/

/**
 * 1. timestamp不一定是排好序的，先用comparator把Log排好序 => 得到一个Log类的List.
 * 2. Find for every user separately the websites he visited.
 * 先遍历一遍logs，把同一个用户按时间顺序访问序列存在哈希表(map1)中
 * 3. 遍历map1中的用户，对于每个用户的访问序列，生成所有可能的3-sequence visit pattern, 并存在
 * 希表中(map2).特别注意的是，这里同一个用户的同一个visit pattern只算一次,所以还要用Set来检验
 * 4. 在更新map2的过程中，同时也更新当前的most frequent visit pattern and the corresponding times
 * 这个更新过程，同样要注意If there is more than one solution, return the lexicographically smallest such 3-sequence.
 */

import java.util.*;

class Solution {
  class Log {
      String username;
      int timestamp;
      String website;
      public Log(String _username, int _timestamp, String _website) {
          username = _username;
          timestamp = _timestamp;
          website = _website;
      }
  }
  // Comparator for Log
  class LogComparator implements Comparator<Log> {
      @Override
      public int compare(Log log1, Log log2) {
          if (log1.timestamp < log2.timestamp) {
              return -1;
          } else if (log1.timestamp > log2.timestamp) {
              return 1;
          }
          return 0;
      }
  }
  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
      // create log
      int n = timestamp.length;
      List<Log> logs = new ArrayList<Log>();
      for (int i = 0; i < n; i++) {
          logs.add(new Log(username[i], timestamp[i], website[i]));
      }

      // use comparator to sort the log
      Collections.sort(logs, new LogComparator());

      // map1: <Username, List<String>>
      Map<String, List<String>> userVisitMap = new HashMap<>();
      // map2: <3-sequence, Integer>>
      Map<List<String>, Integer> patternTimesMap = new HashMap<>();

      // iterate timestamp to build map1
      for (int i = 0; i < logs.size(); i++) {
          List<String> visPattern = userVisitMap.getOrDefault(logs.get(i).username, new ArrayList<String>());
          visPattern.add(logs.get(i).website);
          userVisitMap.put(logs.get(i).username, visPattern);
      }

      // iterate userVisitMap and generate all 3-sequence pattern
      List<String> mostVisitPattern = new ArrayList<String>();
      int maxFreq = Integer.MIN_VALUE;
      for (String user : userVisitMap.keySet()) {
          List<String> visPattern = userVisitMap.get(user);
          int size = visPattern.size();
          // use set to make sure a certain for one user can only count for once
          Set<List<String>> set = new HashSet<List<String>>();
          for (int i = 0; i <= size - 3; i++) {
              for (int j = i + 1; j <= size - 2; j++) {
                  for (int k = j + 1; k <= size - 1; k++) {
                      List<String> threeSequence = new ArrayList<String>();
                      threeSequence.add(visPattern.get(i));
                      threeSequence.add(visPattern.get(j));
                      threeSequence.add(visPattern.get(k));
                      if (set.contains(threeSequence)) continue;
                      set.add(threeSequence);
                      int times = patternTimesMap.getOrDefault(threeSequence, 0);
                      times++;
                      patternTimesMap.put(threeSequence, times);
                      if (times > maxFreq) {
                          maxFreq = times;
                          mostVisitPattern = new ArrayList<String>(threeSequence);
                      } else if (times == maxFreq) {
                          // If there is more than one solution, 
                          // return the lexicographically smallest such 3-sequence.
                          mostVisitPattern = new ArrayList<String>(getAlphabetSequence(mostVisitPattern, threeSequence));
                      }
                  }
              }
          }
      }
      return mostVisitPattern;
  }

  // return the lexicographically smallest such 3-sequence
  private List<String> getAlphabetSequence(List<String> mostVisitPattern, List<String> threeSequence) {
      for (int i = 0; i < 3; i++) {
          // compare every website
          int index = 0;
          String w1 = mostVisitPattern.get(i);
          String w2 = threeSequence.get(i);
          while (index < w1.length() && index < w2.length()) {
              if (w1.charAt(index) < w2.charAt(index)) {
                  return mostVisitPattern;
              } else if (w1.charAt(index) > w2.charAt(index)) {
                  return threeSequence;
              }
              index++;  // word1.charAt(index) == word2.charAt(index)
          }

          if( index == w1.length() && index < w2.length() ) {
              return mostVisitPattern;
          }
          if( index == w2.length() && index < w1.length() ) {
              return threeSequence;
          }
      }
      return mostVisitPattern;
  }
}
