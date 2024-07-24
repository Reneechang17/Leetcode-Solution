import java.util.HashSet;
import java.util.Set;

class Solution {
  public int minAreaRect(int[][] points) {
      Set<String> pointSet = new HashSet<>();
      for (int[] point : points) {
          pointSet.add(point[0] + "," + point[1]);
      }

      int minArea = Integer.MAX_VALUE;
      for (int i = 0; i < points.length; i++) {
          for (int j = 0; j < points.length; j++) {
              if (i != j) {
                  int[] p1 = points[i];
                  int[] p3 = points[j];
                  if (p1[0] != p3[0] && p1[1] != p3[1]) {
                      if (pointSet.contains(p1[0] + "," + p3[1]) && pointSet.contains(p3[0] + "," + p1[1])) {
                          int area = Math.abs(p1[0] - p3[0]) * Math.abs(p1[1] - p3[1]);
                          minArea = Math.min(minArea, area);
                      }
                  }
              }
          }
      }
      return minArea == Integer.MAX_VALUE ? 0 : minArea;
  }
}

/**
 * 最小矩形面積：給定在xy平面上的一組點，確定由這些點組成的矩形最小面積，其中矩形的邊平行於x軸與y軸。如果沒有任何矩形則返回0
 * 
 * 首先要先明確什麼情況下會形成矩形的大小和位置，可以看example，也就是其對角線
 * 直接舉例對於(1, 1) 和(3, 3)，如果他們可以成為矩形，那麼點(1, 3)和(3, 1)也必須存在，
 * 也可以想成(x1, y1) 和(x3, y3) 對應的是(x1, y3)和(x3, y1)
 * 如果四個點都存在，就可以計算面積 即 |x1 - x3| * |y1 - y3|
 * 
 * 具體思路：
 * 1. 先用一個哈希set來紀錄所有點，便於快速查找任何一個點是否存在
 * 2. 遍歷points，可以用example1作為demo，當p1[0] != p3[0] && p1[1] != p3[1]時，找他們對應的的p1[0]+p3[1]和p3[0]+p1[1]是否存在
 * 3. 如果存在的話就計算其矩形面積，並且不斷更新最小面積
 **/