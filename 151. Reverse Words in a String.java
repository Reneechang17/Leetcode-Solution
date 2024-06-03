// Medium
// String, Two Pointers
// O(n)

// use python is more proper
// class Solution:
//     def reverseWords(self, s: str) -> str:
//         s = s.strip()
//         s = s[::-1]
//         s = ' '.join(word[::-1] for word in s.split())
//         return s
        

class Solution {
  public String reverseWords(String s) {
      // use char[] to implement what StringBuilder do
      char[] chars = s.toCharArray();
      // 1. remove the space at start, end and middle
      chars = removeSpace(chars);
      // 2. reverse whole string整個字符串反轉
      reverse(chars, 0, chars.length - 1);
      // 3. then reverse the word
      reverseWord(chars);
      return new String(chars);
  }
  // remove spaces: only left the space for words and words 
  // fast: to remove the space
  // slow: add space 
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
  // reverse String
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
  // then reverse the words 
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