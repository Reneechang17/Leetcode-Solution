// Hard
// Math, String
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/integer-to-english-words/

class Solution {
    // Break the number into chunks of 3 digits (thousands, millions, etc.).
    // Use recursion to process each chunk, leveraging arrays for "less than 20", "tens", and "thousands".
    // Combine the results from each chunk, appending the corresponding "thousands" label.
    private String[] less_than_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",  "Nineteen"};
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) 
                words = helper(num % 1000) + thousands[i] + " " + words;
            num /= 1000;
            i++;
        }
        return words.trim();
    }
    private String helper(int num) {
        if (num == 0) 
            return "";
        else if (num < 20) 
            return less_than_20[num] + " ";
        else if (num < 100) 
            return tens[num / 10] + " " + helper(num % 10);
        else 
            return less_than_20[num / 100] + " Hundred " + helper(num % 100);
    } 
}

/**
 * 思路： 
 * 首先要理解英文數字的結構：1. 單位（Hundred, Thousand, Million, Billion) 2. 小於20的數 3. 十位數（可以先定義）
 * 這題的edgecases比較多：例如 zero的處理，空“”的處理
 **/
