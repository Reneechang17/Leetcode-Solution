class Solution {
    public boolean doesAliceWin(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c))
                cnt++;
        }
        return cnt > 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
