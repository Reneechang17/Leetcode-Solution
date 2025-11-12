// Hard
// Array
// Time:O(n^2), Space:O()
// https://leetcode.cn/problems/couples-holding-hands/

class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int swaps = 0;

        for (int i = 0; i < n; i += 2) {
            int first = row[i];
            int partner = getPartner(first);

            if (row[i + 1] == partner)
                continue;

            for (int j = i + 2; j < n; j++) {
                if (row[j] == partner) {
                    swap(row, i + 1, j);
                    swaps++;
                    break;
                }
            }
        }
        return swaps;
    }

    private int getPartner(int p) {
        if (p % 2 == 0) {
            return p + 1;
        } else {
            return p - 1;
        }
    }

    private void swap(int[] row, int i, int j) {
        int tmp = row[i];
        row[i] = row[j];
        row[j] = tmp;
    }
}
