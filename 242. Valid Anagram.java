// Easy
// Hash Table, Array, String
// O(m + n)

class Solution {
  public boolean isAnagram(String s, String t) {
      int[] record = new int[26];
      // iterate s(add)
      for(int i = 0; i < s.length(); i++){
          char cur = s.charAt(i);
          int idx = cur - 'a';
          int cntCurIdx = record[idx];
          cntCurIdx++;
          record[idx] = cntCurIdx;
      }
      // iterate t(minus)
      for (int i = 0; i < t.length(); i++) {
        char cur = t.charAt(i);
        int idx = cur - 'a';
        int cntCurIdx = record[idx];
        cntCurIdx--;
        record[idx] = cntCurIdx;
      }
      // if the char num in s and t are same, the count will be 0
      for(int count : record){
          if(count != 0){
              return false;
          }
      }
      return true;
  }
}
