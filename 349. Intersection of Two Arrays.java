import java.util.ArrayList;
import java.util.List;

// Easy
// Hash Table, Array
// O(m + n)

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
      int[] hash1 = new int[1001];
      int[] hash2 = new int[1001];
      for(int i : nums1){
          hash1[i]++;
      }
      for(int i : nums2){
          hash2[i]++;
      }
      List<Integer> res = new ArrayList<>();
      for(int i = 0; i < 1001; i++){
          if(hash1[i] > 0 && hash2[i] > 0){
              res.add(i);
          }
      }
      int idx = 0;
      int[] resList = new int[res.size()];
      for(int i : res){
          resList[idx] = i;
          idx++;
      }
      return resList;
  }
}
