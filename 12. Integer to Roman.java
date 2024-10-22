// Medium
// String
// O(1)
// https://leetcode.cn/problems/integer-to-roman/

class Solution {
    // 羅馬數字的構建規則：1. 一個羅馬數字重複幾次，就是這個數的幾倍 2. 右加左減
    // 可以從高位的數字開始處理，4和9是特殊情況，可以直接將他們加到數組省去特殊處理
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
