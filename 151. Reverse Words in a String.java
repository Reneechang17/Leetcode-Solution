// Medium
// String, Two Pointers
// O(n)
// https://leetcode.com/problems/reverse-words-in-a-string/description/

// Python version
// class Solution:
//     def reverseWords(self, s: str) -> str:
//         s = s.strip()
//         s = s[::-1]
//         s = ' '.join(word[::-1] for word in s.split())
//         return s
        

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        chars = removeSpace(chars);
        reverse(chars, 0, chars.length - 1);
        reverseWord(chars);
        return new String(chars);
    }
  // Remove space
  public char[] removeSpace(char[] chars){
      int slow = 0;
      for(int fast = 0; fast < chars.length; fast++){
          if(chars[fast] != ' '){
              if(slow != 0)
                  chars[slow++] = ' ';
              // when fast occur space or reach the end -> iterate is ending
              while (fast < chars.length && chars[fast] != ' ') 
                  chars[slow++] = chars[fast++];
          }
      }
      char[] newChars = new char[slow];
      System.arraycopy(chars, 0, newChars, 0, slow);
      return newChars;
  }
  // Reverse String
  public void reverse(char[] chars, int left, int right){
      // if(right >= chars.length) return;
      while(left < right){
          chars[left] ^= chars[right];
          chars[right] ^= chars[left];
          chars[left] ^= chars[right];
          left++;
          right--;
      }
  }
  // Reverse words 
  public void reverseWord(char[] chars){
      int start = 0;
      for(int end = 0; end <= chars.length; end++){
          // when we occur the end or space
          if(end == chars.length || chars[end] == ' '){
              reverse(chars, start, end - 1);
              start = end + 1;
          }
      }
  }
}

/**
 * 思路：
 * 1. 刪除多餘的空格
 * 2. 反轉整個字符串
 * 3. 反轉每一個單詞
 **/