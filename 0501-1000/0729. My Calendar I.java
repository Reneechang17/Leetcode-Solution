// Medium
// Interval 
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/my-calendar-i/

import java.util.*;

class MyCalendar {
    private List<int[]> todos;

    public MyCalendar() {
        todos = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] todo : todos) {
            if (startTime < todo[1] && endTime > todo[0]) {
                return false;
            }
        }
        todos.add(new int[]{startTime, endTime});
        return true;
    }
}
