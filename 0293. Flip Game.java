// Easy
// String
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/flip-game/

import java.util.*;

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                String newState = currentState.substring(0, i) + "--" + currentState.substring(i + 2);
                res.add(newState);
            }
        }
        return res;
    }
}
