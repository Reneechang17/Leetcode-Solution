// Hard
// Stack
// O(n)
// https://leetcode.cn/problems/basic-calculator/

import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, number = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * number;
                number = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if (number != 0) {
            res += sign * number;
        }
        return res;
    }
}

/**
 * 在不能使用內置函數的前提下實現一個基礎計算器，處理題目給定的String
 * String中只會有數字，+-符號以及（）
 * 
 * 補充：一般這種計算器，括號匹配都可以使用棧處理
 * 
 * 初始化res和number（當前解析的數字）以及用sign來表示正負號（1/-1）
 * 
 * for遍歷s
 * 對遍歷到的每個字符做對應的操作：
 * 1. 如果當前為數字，則需要做解析操作：用number * 10加上當前字符
 *      ex.如果遍歷234，第一個拿到2，用number初始化為0，也就是0*10+2 = 2，再賦值給number；
 *         下一個遍歷到3，用已經更新到number（2）*10+3=23，賦值給number；
 *         最後遍歷到4，再用23*10+4，可以得到我們要的234
 * 2. 如果當前遍歷到加號，就把之前的數字（number）和符號（sign）加入res中，再對number和sign做下一輪的初始更新
 * 3. 同理操作減號的情況，只不過sign = -1
 * 4. 如果遇到左括號，就把當前結果和符號入棧（注意順序），並且重置res = 0 以及sign，準備計算括號內的表達式
 * 5. 如果遇到右括號，先將括號內的計算結果加到res中，再乘上之前的符號並加上之前的結果
 * 
 * edgecase：如果表達式之後還有數字，需要再處理一下
 **/
