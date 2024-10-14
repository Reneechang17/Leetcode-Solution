// Hard
// TreeMap + DoubleLinkedList
// O(1) & O(logn)
// https://leetcode.cn/problems/max-stack/

import java.util.*;
class MaxStack {
    // 因為需要實現O(logn)，因此不能使用普通的棧，需要用TreeMap來優化
    // 用TreeMap用來追蹤棧中元素和其頻率
    TreeMap<Integer, List<Node>> map = new TreeMap<>();
    DoubleLinkedList dll = new DoubleLinkedList();


    public MaxStack() {

    }
    
    // 將元素壓入棧
    public void push(int x) {
        Node node = dll.add(x); // 在ddl中添加節點
        map.putIfAbsent(x, new ArrayList<>()); // 先檢查TreeMap有沒有這個key，沒有就初始化一個
        map.get(x).add(node); // 將鏈表節點加入TreeMap中
    }
    
    // 將棧頂元素移出並返回
    public int pop() {
        int val = dll.pop();
        List<Node> list = map.get(val); // 獲取這個值在TreeMap中對應的節點列表
        list.remove(list.size() - 1); // 移除最後一個節點
        if (list.isEmpty()) map.remove(val); // 如果這個值所在的列表中是空的，直接在TreeMap中移除這個值
        return val;
    }
    
    // 獲取棧頂的元素
    public int top() {
        return dll.peek();
    }
    
    // 獲取TreeMap中的最大值 -> 就是棧中的最大值 -> 用lastKey方法獲取
    public int peekMax() {
        return map.lastKey();
    }

    // 獲取棧中最大的元素並且移除它，如果有超過一個最大元素，只移除最大的那個
    public int popMax() {
        int max = peekMax();
        List<Node> list = map.get(max); // 獲取最大值對應的節點列表
        Node node = list.remove(list.size() - 1); // 移除該值的最後一個節點
        dll.remove(node);
        if (list.isEmpty()) map.remove(max);
        return max;
    }

    class Node {
        int val;
        Node prev, next;
        Node(int v) {
            val = v;
        }
    }

    class DoubleLinkedList {
        Node head, tail;
        
        public DoubleLinkedList() {
            head = new Node(0); // 虛擬頭節點
            tail = new Node(0); // 虛擬尾節點
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val) {
            Node node = new Node(val); // 創建新的節點
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            return node;
        }

        public int pop() {
            return remove(tail.prev).val; // 彈出鏈表的最後一個節點
        }

        public int peek() {
            return tail.prev.val;
        }

        public Node remove(Node node) {
            // prevNode <-> node <-> nextNode
            node.prev.next = node.next; // 從鏈表中移除這個節點
            node.next.prev = node.prev;
            return node;
        }
    }
}
