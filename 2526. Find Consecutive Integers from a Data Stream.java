// Medium
// Design
// https://leetcode.cn/problems/find-consecutive-integers-from-a-data-stream/

class DataStream {
    private int val, k, cnt;

    public DataStream(int value, int k) {
        this.val = value;
        this.k = k;
        this.cnt = 0;
    }
    
    public boolean consec(int num) {
        if (num == val) {
            cnt++;
        } else {
            cnt = 0;
        }
        return cnt >= k;
    }
}
