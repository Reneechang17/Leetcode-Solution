// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/string-compression/

class Solution {
    public int compress(char[] chars) {
        int write = 0, read = 0;
        while (read < chars.length) {
            char cur = chars[read];
            int count = 0;

            // count the freq of cur char
            while (read < chars.length && chars[read] == cur) {
                read++;
                count++;
            }

            chars[write++] = cur; // write cur char
            if (count > 1) { // if freq>1, transfer count to char and write in
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}
