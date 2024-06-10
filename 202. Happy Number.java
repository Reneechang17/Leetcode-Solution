import java.util.HashSet;
import java.util.Set;

// Easy
// Hash Table, Math
// O(logn)

class Solution {
  public boolean isHappy(int n) {
      Set<Integer> record = new HashSet<>();
      while(n != 1 && !record.contains(n)){
          record.add(n); 
          int res = 0; 
          while(n > 0){
              int digit = n % 10; 
              res += digit * digit;
              n = n / 10; 
          }
          n = res; 
      }
      return n == 1;
  }
}
