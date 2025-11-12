// Medium
// PriorityQueue
// https://leetcode.cn/problems/seat-reservation-manager/

import java.util.PriorityQueue;

class SeatManager {

    private PriorityQueue<Integer> seats;

    public SeatManager(int n) {
        seats = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            seats.offer(i);
        }
    }
    
    // Time:O(logk), Space:O(k)
    public int reserve() {
        return seats.poll();
    }

    // Time:O(logk), Space:O(k)
    public void unreserve(int seatNumber) {
        seats.offer(seatNumber);
    }
}
