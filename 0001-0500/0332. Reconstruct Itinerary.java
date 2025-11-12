// Hard
// DFS, Priority Queue
// O(n logm)
// https://leetcode.com/problems/reconstruct-itinerary/

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
  private Deque<String> res;
  private Map<String, Map<String, Integer>> map;

  private boolean backtracking(int ticketNum) {
    if (res.size() == ticketNum + 1) {
      return true;
    }

    // 獲取當前行程的最後一個地點
    String last = res.getLast();
    if (map.containsKey(last)) {
      for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
        int count = target.getValue();

        if (count > 0) {
          res.add(target.getKey()); // 如果有，就嘗試把這個target加到res中
          target.setValue(count - 1);  // 並且減少先對應的機票計數
          if (backtracking(ticketNum))  // 回溯
            return true;
          res.removeLast();
          target.setValue(count);
        }
      }
    }
    return false;
  }

  // 主方法：用於找行程
  public List<String> findItinerary(List<List<String>> tickets) {
    map = new HashMap<String, Map<String, Integer>>();
    res = new LinkedList<>();

    for (List<String> t : tickets) {
      Map<String, Integer> temp;

      if (map.containsKey(t.get(0))) {
        temp = map.get(t.get(0));
        temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
      } else {
        temp = new TreeMap<>();
        temp.put(t.get(1), 1);
      }
      map.put(t.get(0), temp);
    }
    res.add("JFK");
    backtracking(tickets.size());
    return new ArrayList<>(res);
  }
}

/**
 * 重新安排行程：給定一系列機票的列表，每張機票表示為字符串對["from", "to"]，要求透過給定的機票重新構建行程，行程必須從JFK機場出發
 * 盡可能的使用所有機票，並且每張機票都必須恰好使用一次，按照字母順序返回最小的行程路徑。
 * 
 * 遞歸思路：每次遞歸都把下一個目的地加入行程中，如果加入新的目的地後，可以繼續找都後續的合適路徑就繼續遞歸；如果不行，就停止當前的遞歸
 * 遞歸代碼邏輯：
 * 1. 參數：機票的總數，用於知道何時使用過所有機票
 * 2. 終止條件：當res的大小等於機票數量+1時，代表所有機票都已經被使用過（因為行程的長度總是比使用的機票數量多一，最後一個目的地沒有對應的出發機場）
 * 3. 單層遞歸邏輯
 * a. 先獲取當前行程的最後一個地點last
 * b. 檢查是否有這個地點出發的機場（看能不能接續）
 * c. 對於每個從last出發的目的地，檢查是否有剩餘的機票（即機票計數 > 0）
 * d. 如果有剩餘的機票，就嘗試把該目的地加入行程，並減少對應的機票計數
 * e. 遞歸，如果這個遞歸找到一個有效的行程，就返回true；如果沒有找到，就撤銷這次的嘗試，從行程中移除last，並恢復機票計數
 * 
 * 主方法用於找行程+構建圖：將每張機票插入圖中，對於每個出發點，使用TreeMap來存儲到達點和對應到機票數量
 * 使用TreeMap是為了保證到達點是有序的，這樣可以保證字典序最小的路徑被有限選擇
 **/