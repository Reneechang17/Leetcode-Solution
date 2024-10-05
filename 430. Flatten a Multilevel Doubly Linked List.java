// Medium
// DFS
// O(n)
// https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/

class Solution {
  public Node flatten(Node head) {
    if (head == null)
      return head;

    // 偽節點作為新的頭節點的前一個節點
    Node dummy = new Node();
    dummy.next = head;

    dfs(dummy, head);

    // remove偽節點
    dummy.next.prev = null;
    return dummy.next;
  }

  private Node dfs(Node pre, Node cur) {
    if (cur == null)
      return pre;

    cur.prev = pre;
    pre.next = cur;

    Node tempNext = cur.next; // 先保存當前節點的next指針

    // 如果當前節點有子節點，則遞歸處理子節點
    Node tail = dfs(cur, cur.child);
    cur.child = null; // 扁平化後要將child指針置空

    // 遞歸處理當前節點的next節點
    return dfs(tail, tempNext);
  }
}

/**
 * 扁平化多級雙向鏈表：給定一個多級雙向鏈表，每個節點有prev和next指針，以及一個child指針，指向其子節點
 * 這題可以用DFS做，因為有給定prev和next指針
 * 從頭節點開始，遇到child時，需要把child鏈表插入到當前節點與其next節點之間
 * 插入child鏈表後還需要繼續遍歷child鏈表的最後一個節點，再將原來的next節點接到這個child鏈表的末尾
 **/

/**
 * Follow up: 如果去掉prev指針，該怎麼做？
 * 可以考慮用Stack：從鏈表的頭節點開始，遍歷每個節點，如果遇到child，先將當前節點的next指針壓入棧中，然後將child節點鏈接到當前的next
 * 當child鏈表處理完時，如果棧不為空，則從棧中彈出先前保存的next節點，並連接到當前處理完的child鏈表的末尾
 * 繼續遍歷next節點，直到所有節點都處理完
 */