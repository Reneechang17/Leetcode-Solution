import java.util.List;
import java.util.PriorityQueue;

// Hard 
// Priority Queue
// O(N * log k)
// N: all the elements number in all list
// k: the number of lists

class Solution {
  public int[] smallestRange(List<List<Integer>> nums) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
      int maxVal = Integer.MIN_VALUE;
      int start = -1, end = -1, minRange = Integer.MAX_VALUE;

      // the queue stored: (value, list_index, element_index)
      for(int i = 0; i < nums.size(); i++){
          pq.offer(new int[]{nums.get(i).get(0), i, 0});
          maxVal = Math.max(maxVal, nums.get(i).get(0));
      }

      while(true){
          int[] min = pq.poll();
          int minVal = min[0], listIndex = min[1], eleIndex = min[2];
          if(maxVal - minVal < minRange){
              minRange = maxVal - minVal;
              start = minVal;
              end = maxVal;
          }
          if(eleIndex + 1 == nums.get(listIndex).size()) break;

          int nextVal = nums.get(listIndex).get(eleIndex + 1);
          pq.offer(new int[]{nextVal, listIndex, eleIndex + 1});
          maxVal = Math.max(maxVal, nextVal);
      }
      return new int[]{start, end};
  }
}