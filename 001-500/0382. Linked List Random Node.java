// Medium
// Reservoir Sampling
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/linked-list-random-node/

import java.util.Random;

class Solution {
  private ListNode head;
  private Random random;

  public Solution(ListNode head) {
    this.head = head;
    this.random = new Random();
  }

  public int getRandom() {
    ListNode cur = head;
    int res = cur.val; // 先选第一个数字
    int i = 1; // 当前遍历元素的个数
    while (cur != null) {
      // 1/i 的概率选择当前元素
      // 用 random.nextInt(i) == 0 模拟生产[0,i-1]的随机数
      if (random.nextInt(i) == 0) {
        res = cur.val;
      }
      cur = cur.next;
      i++;
    }
    return res;
  }
}

// 目标是让每个元素被选中的概率都是1/n，蓄水池抽样可以达成：
// 1.遍历链表，维护一个res变量存储当前选中的元素值
// 2.对于第i个节点：以1/i的概率选择当前节点，以1/(i-1)的概率保留原来的res值
// 3.遍历结束后，res中存储的就是随机选择的元素值
