import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Hard 
// Sliding Window, Hash Table
// O(m + n)

class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> res = new ArrayList<>();
      if(s == null || words == null || s.length() == 0 || words.length == 0) return res;
      int wordLen = words[0].length(); // the length of each word
      int numWords = words.length; // how many words
      int windowSize = wordLen * numWords; // windowSize = wordLen * numWords
      // set hash table for words
      Map<String, Integer> wordCnt = new HashMap<>();
      for(String word : words){
          wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
      }
      // Sliding window
      // Notes: can start anywhere in s
      // If the length of the word is wordLen, i(i < wordLen) in s could be the start of a valid sequence.
      for(int i = 0; i < wordLen; i++){
          int left = i, right = i;
          Map<String, Integer> curCnt = new HashMap<>();
          while(right + wordLen <= s.length()){
              // handle expand the window(move right)
              String w = s.substring(right, right + wordLen);
              right += wordLen;
              // update window
              if(wordCnt.containsKey(w)){
                  curCnt.put(w, curCnt.getOrDefault(w, 0) + 1);
                  // shrink the window
                  while(curCnt.get(w) > wordCnt.get(w)){
                      String leftWord = s.substring(left, left + wordLen);
                      curCnt.put(leftWord, curCnt.get(leftWord) - 1);
                      left += wordLen;
                  }
                  // collect the valid res
                  if(right - left == windowSize){
                      res.add(left);
                      String leftWord = s.substring(left, left + wordLen);
                      curCnt.put(leftWord, curCnt.get(leftWord) - 1);
                      left += wordLen;
                  }
              } else {
                  curCnt.clear();
                  left = right;
              }
          }
      }
      return res;
  }
}
