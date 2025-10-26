// Medium
// Design
// https://leetcode.cn/problems/simple-bank-system/

class Bank {
    
    private long[] balance;
    private int n;
    
    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        // Check acc valid
        if (!isValidAcc(account1) || !isValidAcc(account2))
            return false;

        // Check enough money to transfer
        if (balance[account1 - 1] < money)
            return false;

        // Transfer
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAcc(account))
            return false;

        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAcc(account))
            return false;
        
        if (balance[account - 1] < money)
            return false;
        
        balance[account - 1] -= money;
        return true;
    }

    private boolean isValidAcc(int acc) {
        return acc >= 1 && acc <= n;
    }
}
