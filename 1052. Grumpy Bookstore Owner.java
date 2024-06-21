// Medium
// Sliding Window
// O(N)
// https://leetcode.com/problems/grumpy-bookstore-owner/

class Solution {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
      int total = 0, maxSave = 0, save = 0;
      
      for(int i = 0, j = 0; i < customers.length; i++) {
          total += grumpy[i] == 0 ? customers[i] : 0; // 不生氣的
          save += grumpy[i] == 1 ? customers[i] : 0; // 老闆生氣，客戶不滿意，加入save

          // 如果窗口的長度超過minute，需要從save中減去窗口最左邊的元素
          if(i - j > minutes) {
              save -= grumpy[j] == 1 ? customers[j] : 0;
              j++;
          }
          maxSave = Math.max(save, maxSave);
      }
      return total + maxSave;

  }
}

/**
 * 這題題目蠻難讀懂的==
 * 題目：有一個書店老闆，他的店開n分鐘，每分鐘會有一些客人來這個店。
 *      給定一個長度為n的整數數組customers，其中customers[i]是第i分鐘進入這個店的顧客數量，所有顧客會在第i分鐘結束之
 *      後離開書店。 
 *      某些時候，這個書店的老闆會生氣，如果老闆在第i分鐘生氣，那麼grumpy[i] = 1，否則 = 0。
 *      當老闆生氣時，那一分鐘的顧客就會不滿意，如果老闆不生氣的話就是滿意的。
 *      而老闆能夠擁有minute分鐘的抑制情緒，但只能使用一次。
 *      返回這一天營業下來，最多可以有多少顧客可以感到滿意
 * 
 * 思考：這種找最多怎樣的題目，一般可以聯想到用滑動窗口+雙指針進行操作，可以確定的是，只要grumpy[i] = 0，那麼與之對應的顧客就是滿意的。
 * 另外就是找大小為minute的窗口中，老闆生氣時的客戶數量最大的可能是多少（讓這段時間老闆冷靜）
 **/