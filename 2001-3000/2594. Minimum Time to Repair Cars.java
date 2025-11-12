// Medium
// Binary Search
// Time:O(n long(max_time)), Space:O(1)
// https://leetcode.cn/problems/minimum-time-to-repair-cars/

// The first thing is... understand the problem...
// ranks=[4,3,2,1] <-- four workers, cars = 10
// worker1(rank4)     worker2(rank2)    worker3(rank3)   worker4(rank1)
// - car 1 - 4mins      2mins             3mins            1min
// - car 2 - 16mins     8mins             12mins           4mins
// - car 3 - 36mins     18mins            27mins           9mins
// - car 4                                                 16mins
// - repair 2(16mins)   2(10mins)         2(15mins)        3(14mins)
// 2+2+2+3=10 

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) ranks[0] * cars * cars; // worse case

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepair(ranks, cars, mid)) {
                right = mid; // find shorter time
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canRepair(int[] ranks, int cars, long time) {
        long total = 0;

        for (int r : ranks) {
            // how many car could repair by this worker?
            // r * n^2 <= time
            // n <= sqrt(time/r)
            total += (long) Math.sqrt(time / r);
        }
        return total >= cars;
    }
}
