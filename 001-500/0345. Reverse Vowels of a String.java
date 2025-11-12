// Easy
// Two Pointers, String
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/reverse-vowels-of-a-string/

class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // no need to swap
            while (left < right && !isVowels(chars[left])) {
                left++;
            }
            while (left < right && !isVowels(chars[right])) {
                right--;
            }

            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    private boolean isVowels(char c) {
        // indexOf() return char index in the string ("")
        String vowels = "aeiouAEIOU";
        return vowels.indexOf(c) != -1; // if it is vowel, it will give an index, or -1
    }
}
