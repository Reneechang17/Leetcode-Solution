// Medium
// Recursion, Memoization
// O(2^n)
// https://leetcode.cn/problems/can-i-win/

class Solution {
    // 遞歸+記憶化搜索
    private Boolean[] memo; // 記憶化搜索，保存每個狀態的結果
    private int maxChoosableInteger, desiredTotal;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 所有數字的和小於目標值，誰都不能贏
        // 等差數列求和公式：s = n*(n+1) / 2
        int totalSum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (totalSum < desiredTotal) return false;

        // 當目標值為0或是負值，先手直接贏
        if (desiredTotal <= 0) return true;

        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        memo = new Boolean[1 << maxChoosableInteger]; // 用二進制表示數字的使用狀態

        return helper(0, 0); // 遞歸，初始狀態未選擇任何數字
    }

    // used表示哪些數字被選過了，total表示當前累加和
    private boolean helper(int usedNumbers, int curTotal) {
        // 如果已經保存過數字，直接返回
        if (memo[usedNumbers] != null) return memo[usedNumbers];

        // 嘗試每一個數字
        for (int i = 0; i < maxChoosableInteger; i++) {
            int currentMask = (1 << i); // 當前數字的掩碼
            // 如果數字i+1已經被選擇過，跳過
            if ((usedNumbers & currentMask) != 0) continue;

            // 如果選擇i+1後，當前玩家可以勝利，或是對方不能獲勝，則返回true
            if (curTotal + (i + 1) >= desiredTotal || !helper(usedNumbers | currentMask, curTotal + (i + 1))) {
                memo[usedNumbers] = true;
                return true;
            } 
        }
        // 無論如何都不能獲勝，返回false
        memo[usedNumbers] = false;
        return false;
    }
}

/**
 * Can I win?：博弈問題。給定整數maxChoosableInteger和desiredTotal，兩個玩家輪流從1到maxChoosableInteger中選擇數字，每次選擇的數字不能重複，直到總和達到desiredTotal為止。如果兩名玩家都是最佳策略，第一個玩家是否能夠贏得比賽？
 * 
 * 遞歸：每個玩家都希望自己贏，因此每一步都會選擇最優解。因此在遞歸時，需要檢查下一步對方是否會輸，如果對方一定會輸，則先手就一定贏
 * 狀態表示：因為數字不能重複選，通過數組和位掩碼來判斷哪些數字已經使用過。但是不同選擇也可能會導致相同的狀態重複出現，因此需要記憶化搜索
 **/
