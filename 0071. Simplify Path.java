// Medium
// Stack
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/simplify-path/

import java.util.Stack;
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for (String part : parts) {
            // ignore empty string or cur directory
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        return "/" + String.join("/", stack);
    }
}
