// Easy
// Stack, Design
// https://leetcode.cn/problems/implement-queue-using-stacks/

import java.util.Stack;

class MyQueue {
    // Use two Stack to simulate queue
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    public void push(int x) {
        stackIn.push(x);
    }

    // when stackOut is empty, transfer the element from stackIn to stackOut
    // then pop from stackOut
    public int pop() {
        transferToOut();
        return stackOut.pop();
    }
    
    public int peek() {
        transferToOut();
        return stackOut.peek();
    }
    
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void transferToOut() {
        // base to check is valid
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
