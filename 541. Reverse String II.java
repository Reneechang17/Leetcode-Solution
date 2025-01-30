// Easy
// String
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/reverse-string-ii/

class Solution {
    // Convert string to char array and iterate in steps of 2k
    // Reverse first k chars in each 2k segment
    // If fewer than k chars remain, reverse all of them
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            if (i + k <= arr.length) {
                reverse(arr, i, i + k - 1);
                continue;
            } else {
                reverse(arr, i, arr.length - 1);
            }
        }
        return new String(arr);
    }
    private void reverse(char[] arr, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
