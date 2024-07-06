// Medium
// LinkedList
// O(n)
// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

class Solution {
  public int[] nodesBetweenCriticalPoints(ListNode head) {
      int first = -1, last = -1;
      int minDis = Integer.MAX_VALUE;
      ListNode pre = null, cur = head;
      int index = 0;

      while (cur != null && cur.next != null) {
          if (isCriticalPoint(pre, cur, cur.next)) {
              if (first == -1) {
                  first = index;
              } else {
                  minDis = Math.min(minDis, index - last);
              }
              last = index;
          }
          pre = cur;
          cur = cur.next;
          index++;
      }

      if (first == last) {
          return new int[]{-1, -1};
      }
      return new int[] {minDis, last - first};
  }

  private boolean isCriticalPoint(ListNode pre, ListNode cur, ListNode next) {
      if (pre != null && next != null) {
          return (cur.val > pre.val && cur.val > next.val) || (cur.val < pre.val && cur.val < next.val);
      }
      return false;
  }
}

/**
 * 鏈表中的臨界點定義為：
 * 局部極大值點：當前節點的值嚴格大於前一個節點和後一個節點的值
 * 局部極小值點：當前節點的值嚴格小於前一個節點和後一個節點的值
 * 注意：節點只有在同時存在前一個節點和後一個節點的情況下，才能成為一個局部最大/最小值點
 * 
 * 題目給出一個鏈表head，返回一個長度為2的數組[minDistance, maxDistance]，其中minDistance是任意兩個不同臨界點之間的最小距離，
 * maxDistance則是任意兩個不同臨界點之間的最大距離。如果臨界點小於2，則返回[-1, -1]
 * 
 * 思路：我們需要找出鏈表中的第一個臨界點first和最後一個臨界點last，這樣可以計算出最大距離maxDis = last - frirt
 * 對於最小距離minDis，則是遍歷鏈表，計算出兩個相鄰臨界點之間的距離，用min來取最小值即可
 **/