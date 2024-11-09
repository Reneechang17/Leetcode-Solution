// Medium
// String, Two Pointers
// O(n)
// https://leetcode.cn/problems/reverse-words-in-a-string/

// Python version
// class Solution:
//     def reverseWords(self, s: str) -> str:
//         s = s.strip()
//         s = s[::-1]
//         s = ' '.join(word[::-1] for word in s.split())
//         return s
        

class Solution {
    // 1. we need to remove the space 2. reverse the whole string 
    // 3. reverse each word
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        chars = removeSpace(chars);
        reverse(chars, 0, chars.length - 1);
        reverseWord(chars);

        return new String(chars);
    }

    // 1. remove the space
    public char[] removeSpace(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0) 
                    // add a space to divide the string
                    chars[slow++] = ' ';
                while (fast < chars.length && chars[fast] != ' ') 
                    chars[slow++] = chars[fast++];
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    // 2. reverse the whole string
    public void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) return;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            // chars[left] ^= chars[right];
            // chars[right] ^= chars[left];
            // chars[left] ^= chars[right];
            left++;
            right--;
        }
    }

    // 3. reverse each word in string
    public void reverseWord(char[] chars) {
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
    }
}
