// Easy
// String
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/reverse-string-ii/

class Solution {
    public String reverseStr(String s, int k) {
        // turn the string to string arr
        char[] ch = s.toCharArray();
        // iterate the arr and everytime jump 2k
        for (int i = 0; i < ch.length; i += 2 * k) {
            // check if the length is enough
            if (i + k <= ch.length) {
                reverse(ch, i, i + k - 1);
                continue;
            } else {
                reverse(ch, i, ch.length - 1);
            }
        }
        return new String(ch);
    }
    private void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}
