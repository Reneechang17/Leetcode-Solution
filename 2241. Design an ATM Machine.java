// Medium
// Design
// https://leetcode.cn/problems/design-an-atm-machine/

class ATM {

    private long[] cnt;
    private int[] values = { 20, 50, 100, 200, 500 };

    public ATM() {
        cnt = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cnt[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] output = new int[5];
        int remaining = amount;

        for (int i = 4; i >= 0; i--) {
            long need = remaining / values[i];
            long curNumber = Math.min(need, cnt[i]);

            output[i] = (int) curNumber;
            remaining -= curNumber * values[i];
        }
        
        if (remaining > 0) {
            return new int[] { -1 };
        }

        for (int i = 0; i < 5; i++) {
            cnt[i] -= output[i];
        }

        return output;
    }
}
