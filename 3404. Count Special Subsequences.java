// WIP :D

import java.util.*;

// We could see nums[p] * nums[r] == nums[q] * nums[s] as nums[p] / nums[q] = nums[s] / nums[r],
// then fix (q,r) and calculate how may (p,s) pair match the conditions.
// In simple words(probably), if we fix q and r's pos, the left ratio and right ratio should be the same.

class Solution2 {
    // WTF TLE again:D
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long count = 0;
        
        for (int q = 2; q < n - 4; q++) {       
            for (int r = q + 2; r < n - 2; r++) { 
                
                Map<Long, Integer> leftCount = new HashMap<>();
                for (int p = 0; p <= q - 2; p++) {  
                    long key = (long)nums[p] * nums[r];  
                    leftCount.put(key, leftCount.getOrDefault(key, 0) + 1);
                }
                
                Map<Long, Integer> rightCount = new HashMap<>();
                for (int s = r + 2; s < n; s++) {
                    long key = (long) nums[q] * nums[s];
                    rightCount.put(key, rightCount.getOrDefault(key, 0) + 1);
                }

                for (long key : leftCount.keySet()) {
                    if (rightCount.containsKey(key)) {
                        count += (long)leftCount.get(key) * rightCount.get(key);
                    }
                }
            }
        }
        return count;
    }
}

// I definitely sure there are some funny math ways to optimize it but I'm not a big fans of math:D
// And the sad thing is brute force got TLE so I have to learn the math way tho.

class Solution3 {
    // Brute force -> TLE
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long res = 0;

        for (int p = 0; p < n - 6; p++) {
            for (int q = p + 2; q < n - 4; q++) {
                for (int r = q + 2; r < n - 2; r++) {
                    for (int s = r + 2; s < n; s++) {
                        if ((long) nums[p] * nums[r] == (long) nums[q] * nums[s]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
