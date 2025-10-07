// Easy
// Greedy
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/k-items-with-the-maximum-sum/

//.....???????
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        
        if (k <= numOnes + numZeros) {
            return numOnes;
        }

        return numOnes - (k - numOnes - numZeros);
    }
}
