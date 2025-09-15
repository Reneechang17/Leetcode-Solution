// Easy
// Math, Stack
// Time:O(n logm),Space:O(n)
// https://leetcode.cn/problems/replace-non-coprime-numbers-in-array/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    // LCM最小公倍数(a,b) = a*b/ GCD(a,b)
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int x : nums) {
            stack.push(x);

            while (stack.size() >= 2) {
                int top1 = stack.pop();
                int top2 = stack.pop();

                int g = gcd(top1, top2);

                if (g > 1) {
                    long lcm = (long) top1 * top2 / g;
                    stack.push((int) lcm);
                } else {
                    stack.push(top2);
                    stack.push(top1);
                    break;
                }
            }
        }
        return new ArrayList<>(stack);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
