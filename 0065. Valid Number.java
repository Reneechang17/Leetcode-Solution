// Hard
// String,Simulation
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/valid-number/

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        boolean isDigit = false, isDot = false, isE = false, numAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                isDigit = true;
                numAfterE = true;
            } else if (c == '.') {
                // dot can only appear one time
                // and it cannot following after e/E
                if (isDot || isE) return false;
                isDot = true;
            } else if (c == 'e' || c == 'E') {
                // if e has been appeared and with no leading digits -> return false
                if (isE || !isDigit) return false;
                isE = true;
                numAfterE = false; // e/E should followed by an integer num
            } else if (c == '+' || c == '-') {
                // should be leading or after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else {
                return false;
            }
        }
        // if digits or no digits after e/E -> invalid
        return isDigit && numAfterE;
    }
}
