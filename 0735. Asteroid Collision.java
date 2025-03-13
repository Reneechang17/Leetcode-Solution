// Medium
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/asteroid-collision/

import java.util.Stack;

class Solution {
    // Simulate by Stack
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int x : asteroids) {
            boolean alive = true;
            while (alive && x < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < Math.abs(x);
                if (stack.peek() <= Math.abs(x)) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(x);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
