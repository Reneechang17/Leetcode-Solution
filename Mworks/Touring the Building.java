package Mathworks;

/**
 * Touring the Building
 * 这道题的目标是从建筑的地面（第 0 层）到达目标楼层n，可以选择电梯或者楼梯来前进。每种方式的代价和耗时都不同，且你要确保过程中不会让能量变成负值。最后要求的是 楼梯和电梯耗时的最小差值。
 * 电梯：每次上升一个楼层，需要获得 e1 的能量，花费 t1 的时间。
 * 楼梯：每次上升一个楼层，需要耗费 e2 的能量，花费的时间与当前能量 E 相关，公式为 ceil(c / E)，其中 c 是常数。
 * 初始状态是在第0层开始，能量为0。
 * 目标：选择电梯和楼梯组合的方式，使得总耗时时差最小，同时过程中不能让能量变成负值。
 * the goal of this problem is to reach the target floor n of a building from the ground (floor 0) using either an elevator or stairs. Each method has different costs and time, and we need to ensure that the energy does not become negative during the process. The final requirement is to find the minimum difference between the time spent on stairs and the elevator.
 * 
 * my solution is to calculates optimal floor to switch from elevator to stairs, minimize the time difference between the two. It uses ternary search to locate this switch point, which balance energy gained from the elevator and consumed by the stairs.

getMinDifference: Computes an initial minimum floor iMin for a feasible switch from elevator to stairs, then applies ternary search to find the floor where the time difference is minimized.
ternarySearch: Conducts a ternary search between floors iMin and n to find the optimal switch floor with minimal time difference.
calculateDifference: Calculates the time difference between using the elevator up to a given floor i and using stairs for the remaining floors.
computeTimeOnStairs: Computes the total time taken to ascend remaining floors using stairs, considering energy consumption per floor.

 * time O(nlogn): 三分搜索的时间复杂度是O(logn)
 * space O(1)
 */

class Solution {
  public class TouringTheBuilding {
    // getMinDifference: calculate the minimum difference between elevator and
    // stairs from ground to n
    public static long getMinDifference(int n, int e1, int t1, int e2, int c) {
      // iMin is the ideal floor to switch from elevator to stairs, to ensure the
      // energy is enough
      // before iMin, we use elevator, after iMin, we use stairs
      // 电梯到i层的能量消耗为e1 * i，楼梯到n层的能量消耗为(e2 * n - i) => e1 * i = e2 * n - i
      // => i = (e2 * n) / (e1 + e2) 即理想的切换层
      int iMin = (int) Math.ceil((double) (e2 * n) / (e1 + e2)); // use ceil to round up to ensure the minimum trans
                                                                 // level

      // if the ideal switch level is greater than n, then we can't reach n with
      // enough energy
      if (iMin > n) {
        return -1;
      }

      // use ternary search to find the minimum difference between elevator and stairs
      // from the ideal swich level to n
      return ternarySearch(iMin, n, n, e1, t1, e2, c);
    }

    // ternary search to find the minimum difference between elevator and stairs the
    // ideal swich level to n
    // we choose two mid points, to calculate the time difference
    private static long ternarySearch(int left, int right, int n, int e1, int t1, int e2, int c) {
      // initialize the minDiff to be the max value
      long minDiff = Long.MAX_VALUE;

      while (right - left > 3) {
        // calculate the mid points
        int mid1 = left + (right - left) / 3;
        int mid2 = right - (right - left) / 3;

        // calculate the time difference in the two mid points
        long diff1 = calculateDiff(mid1, n, e1, t1, e2, c);
        long diff2 = calculateDiff(mid2, n, e1, t1, e2, c);

        // update the minDiff
        minDiff = Math.min(minDiff, Math.min(diff1, diff2));

        // adjust the left and right pointers based on the time difference
        if (diff1 < diff2) {
          right = mid2;
        } else {
          left = mid1;
        }
      }

      // calculate the time difference for the rest of the points
      for (int i = left; i <= right; i++) {
        long diff = calculateDiff(i, n, e1, t1, e2, c);
        minDiff = Math.min(minDiff, diff);
      }
      return minDiff;
    }

    // calculate the time difference at floor i
    private static long calculateDiff(int i, int n, int e1, int t1, int e2, int c) {
      // first calculate the total time to reach floor i
      long timeLift = (long) t1 * i;
      // E_start means the total energy used to reach floor i
      long E_start = (long) e1 * i;
      // calculate the remaining floors
      long s = n - i;
      // use computeTimeOnStair to calculate the total time from floor i to n
      long timeStair = computeTimeOnStair(E_start, s, e2, c);
      // calculate and return the absolute value of the difference between elevator
      // time and stairs time
      return Math.abs(timeLift - timeStair);
    }

    // computeTimeOnStair: calculate the total time from floor i to n using stairs
    private static long computeTimeOnStair(long E_start, long s, int e2, int c) {
      // initialize the total time to be 0
      long totalTime = 0;

      // set the initial energy to be E_start
      long E_k = E_start;

      // when the remaining floors s is greater than 0 and the energy is non-negative,
      // continue the loop
      while (s > 0 && E_k >= 0) {
        // calculate the time to reach the next floor
        long T = (c + E_k - 1) / E_k;
        // update the energy for the next floor, consume e2 energy
        long E_k_next = E_k - e2;
        // ensure the energy is non-negative, if E_k_next is less than 0, set it to 0
        if (E_k_next < 0) {
          E_k_next = 0;
        }

        // add the total time
        totalTime += T;
        // update the current energy
        E_k = E_k_next;
        // decrease the remaining floors
        s--;
      }
      // return the total time to reach the remaining floors using stairs
      return totalTime;
    }
  }
}
