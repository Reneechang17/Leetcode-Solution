// Hard
// BIT
// Time:O(n logn), Space:O(n)
// https://leetcode.cn/problems/count-good-triplets-in-an-array/

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n], reverseMapping = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            reverseMapping[pos2[nums1[i]]] = i;
        }

        BIT tree = new BIT(n);
        long res = 0;
        for (int v = 0; v < n; v++) {
            int pos = reverseMapping[v];
            int left = tree.query(pos);
            tree.update(pos, 1);
            int right = (n - 1 - pos) - (v - left);
            res += (long)left * right;
        }
        return res;
    }
}

class BIT {
    private int[] tree;

    public BIT(int size) {
        tree = new int[size + 1];
    }

    public void update(int i, int del) {
        i++;
        while (i < tree.length) {
            tree[i] += del;
            i += i & -i;
        }
    }

    public int query(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }
        return res;
    }
}
