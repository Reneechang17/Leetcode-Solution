// Medium
// Greedy, Stack(Using StringBuilder as stack)
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/remove-k-digits/

class Solution {
    // Use StringBuilder as stack to traverse the num, if cur digit smaller than the last
    //   - digit in stack, pop(delete) the last digit to make it smaller
    // After traverse the string, if k>0, removing from the end of stack
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        String res = stack.toString().replaceAll("^0+", ""); // remove leading zero
        return res.isEmpty() ? "0" : res;
    }
}
