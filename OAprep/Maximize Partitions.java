package OAprep;

// 这道题的目标是将数组 performance 划分成尽可能多的连续子段（partition），使每个子段的所有元素按位与（bitwise AND）操作的结果为 0
// 这题需要了解按位与操作的特点：只要有一个 0，结果就是 0 -> 也就是说，只要找到一个区间所有元素的按位与结果为0，就可以划分一个子段

class Solution{
  public int maximizePartitions(int[] performance) {
    // write your code here
    int count = 0;
    int currentAnd = -1; 
  
    for (int i = 0; i < performance.length; i++) {
      currentAnd &= performance[i];
  
      if (currentAnd == 0) {
        count++;
        currentAnd = -1;
      }
    }
    return count;
  }
}
