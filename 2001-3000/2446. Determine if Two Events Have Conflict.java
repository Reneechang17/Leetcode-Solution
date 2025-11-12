// Easy
// String
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/determine-if-two-events-have-conflict/

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String s1 = event1[0], e1 = event1[1];
        String s2 = event2[0], e2 = event2[1];

        return s1.compareTo(e2) <= 0 && s2.compareTo(e1) <= 0;
    }
}
