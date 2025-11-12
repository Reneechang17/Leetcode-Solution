class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;

        // Simulation
        // knowing[i], sharing[i], newPeople[i]

        long[] newPeople = new long[n + 1];
        newPeople[1] = 1;

        for (int day = 1; day <= n; day++) {
            // they can sharing [day+delay, day+forget-1]
            for (int shareDay = day + delay; shareDay < day + forget && shareDay <= n; shareDay++) {
                newPeople[shareDay] = (newPeople[shareDay] + newPeople[day]) % MOD;
            }
        }

        long res = 0;
        for (int day = Math.max(1, n - forget + 1); day <= n; day++) {
            res = (res + newPeople[day]) % MOD;
        }

        return (int) res;
    }
}
