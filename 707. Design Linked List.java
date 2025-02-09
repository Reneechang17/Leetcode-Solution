// Medium
// LinkedList, Design
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/design-linked-list/

class MyLinkedList {
  private class ListNode {
      int val;
      ListNode next;
      ListNode (int val) {
          this.val = val;
          this.next = null;
      }
  }
  private ListNode head;
  private int size;

  public MyLinkedList() {
      head = null;
      size = 0;
  }
  
  public int get(int index) {
      // get the val on index, if not valid, return -1
      // Time:O(n),Space:O(1)
      if (index < 0 || index >= size) return -1;
      ListNode cur = head;
      for (int i = 0; i < index; i++) {
          cur = cur.next;
      }
      return cur.val;
  }
  
  public void addAtHead(int val) {
      // Time:O(1),Space:O(1)
      ListNode newNode = new ListNode(val);
      newNode.next = head;
      head = newNode;
      size++;
  }
  
  public void addAtTail(int val) {
      // Time:O(n),Space:O(1)
      ListNode newNode = new ListNode(val);
      if (head == null) {
          head = newNode;
      } else {
          ListNode cur = head;
          while (cur.next != null) {
              cur = cur.next;
          }
          cur.next = newNode;
      }
      size++;
  }
  
  public void addAtIndex(int index, int val) {
      // Time:O(n),Space:O(1)
      if (index > size) return; // invalid
      if (index <= 0) {
          addAtHead(val);
          return;
      }
      if (index == size) {
          addAtTail(val);
          return;
      }
      ListNode newNode = new ListNode(val);
      ListNode prev = head;
      for (int i = 0; i < index - 1; i++) {
          prev = prev.next;
      }
      // record original prev'next
      newNode.next = prev.next; 
      prev.next = newNode;
      size++;
  }
  
  public void deleteAtIndex(int index) {
      // Time:O(n),Space:O(1)
      if (index < 0 || index >= size) return;
      if (index == 0) {
          // delete head node
          head = head.next;
      } else {
          ListNode prev = head;
          for (int i = 0; i < index - 1; i++) {
              prev = prev.next;
          }
          prev.next = prev.next.next;
      }
      size--;
  }
}
