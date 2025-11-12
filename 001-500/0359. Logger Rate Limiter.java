// Easy
// OOD, Hash Table
// O(1)
// https://leetcode.com/problems/logger-rate-limiter/

import java.util.HashMap;
import java.util.Map;

class Logger {
  private Map<String, Integer> limiter;

  public Logger() {
    limiter = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    int time = limiter.getOrDefault(message, 0);
    if (time > timestamp)
      return false;

    limiter.put(message, timestamp + 10);
    return true;
  }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

/**
 * 設計一個日誌速率限制器
 * 
 * 簡單來說就是實現一個logger類
 * 而shouldPrintMessage方法則是：如果這條消息在給定的timestamp應該被打印出來則返回true，否則返回false
 * 要求是每條不重複的消息最多只能每10s打印一次，也就是說如果在時間戳打印某條消息，那麼相同內容的消息知道時間戳變成t+10之前都不會被打印出來（即返回false）
 */