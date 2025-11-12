// Easy
// Two Pointers
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/

class Solution {
    public String reverseMessage(String message) {
        char[] chars = message.toCharArray();
        chars = removeSpace(chars);
        reverse(chars, 0, chars.length - 1);
        reverseWord(chars);
        return new String(chars);
    }

    private char[] removeSpace(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0)
                    chars[slow++] = ' ';
                while (fast < chars.length && chars[fast] != ' ')
                    chars[slow++] = chars[fast++];
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    private void reverse(char[] chars, int left, int right) {
        if (right >= chars.length)
            return;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    private void reverseWord(char[] chars) {
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
    }
}
