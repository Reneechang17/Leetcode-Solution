// Medium
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/removing-stars-from-a-string/

class Solution {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
