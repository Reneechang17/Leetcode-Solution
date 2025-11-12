// Medium
// Queue, Design
// Time:O(1),Space:O(k)
// https://leetcode.cn/problems/design-circular-queue/

class MyCircularQueue {
    private int[] que;
    private int front, rear, size;

    public MyCircularQueue(int k) {
        front = 0;
        rear = 0;
        size = k + 1;
        que = new int[size];
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        que[rear] = value;
        rear = (rear + 1) % size; // update rear pointer
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size; // update front pointer
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return que[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return que[(rear - 1 + size) % size]; // deal with circular
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
