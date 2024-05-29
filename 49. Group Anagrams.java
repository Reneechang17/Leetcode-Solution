import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// Medium
// Hash Table, Array, String
// O(N * K)
// N: number of String
// K: the average length of String

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> codeToGroup = new HashMap<>();
      for(String s : strs){
          String code = encode(s);
          codeToGroup.putIfAbsent(code, new LinkedList<>());
          codeToGroup.get(code).add(s);
      }

      List<List<String>> res = new LinkedList<>();
      for(List<String> group : codeToGroup.values()){
          res.add(group);
      }
      return res;
  }

  String encode(String s){
      char[] cnt = new char[26];
      for(char c : s.toCharArray()){
          int pos = c - 'a';
          cnt[pos]++;
      }
      return new String(cnt);
  }
}
