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
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // 去除頭尾和中間多餘的空格
        chars = removeSpace(chars);
        // 整個字符串翻轉
        reverse (chars, 0, chars.length - 1);
        // 將單個單詞反轉
        reverseWord(chars);

        return new String(chars);
    }

    public char[] removeSpace(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if(chars[fast] != ' ') {
                if(slow != 0) 
                    chars[slow++] = ' ';
                while (fast < chars.length && chars[fast] != ' ')
                    chars[slow++] = chars[fast++];
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    public void reverse (char[] chars, int left, int right) {
        if (right >= chars.length) return;
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }

    public void reverseWord (char[] chars) {
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            // Java中的||有短路特性，如果檢查到end == chars.length為 true，就不會接著檢查下一個
            // 所以end == chars.length和chars[end] == ' '不能寫反
            if (end == chars.length || chars[end] == ' ') {
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