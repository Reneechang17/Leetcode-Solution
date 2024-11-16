package OAprep;

// 这道题要求我们根据字符对的删除方式来最小化总成本。可以分成两种情况来处理，具体取决于删除两个相同字符的成本 x 和删除两个不同字符的成本 y 的相对大小：
// 当 x <= y 时：删除两个相同字符的成本更低或相等 -> 应该尽量多地删除相同字符对来节省成本
// 当 x > y 时：删除两个不同字符的成本更低 -> 应该尽量多地创建不同字符对来减少成本

import java.util.*;

class Solution {
  public int cleanupDataset(String dataset, int x, int y) {
    int[] counts = new int[26];
    for (char c : dataset.toCharArray()) {
        counts[c - 'a']++;
    }
    int totalCost = 0;
    int totalIdenticalPairs = 0;
    int totalDifferentPairs = 0;

    if (x <= y) {
        // Maximize identical pairs
        int unpairedLetters = 0;
        for (int count : counts) {
            totalIdenticalPairs += count / 2;
            unpairedLetters += count % 2;
        }
        totalDifferentPairs = unpairedLetters / 2;
        totalCost = totalIdenticalPairs * x + totalDifferentPairs * y;
    } else {
        // Maximize different pairs
        List<Integer> countsList = new ArrayList<>();
        for (int count : counts) {
            countsList.add(count);
        }
        while (true) {
          int first = -1, second = -1;
          // 找到两不同的单词配对
          for (int i = 0; i < countsList.size(); i++) {
            if (countsList.get(i) > 0) {
              first = i;
              break;
            }
          }
          for (int i = first + 1; i < countsList.size(); i++) {
            if (countsList.get(i) > 0) {
              second = i;
              break;
            }
          }
          // 减少各自的数量，totalDifferentPairs++
          if (first != -1 && second != -1) {
            countsList.set(first, countsList.get(first) - 1);
            countsList.set(second, countsList.get(second) - 1);
            totalDifferentPairs++;
          } else {
            break;
          }
        }
        // 所有不同配对完之后，如果还有剩，就是相同的配对
        for (int count : countsList) {
            totalIdenticalPairs += count / 2;
        }
        totalCost = totalIdenticalPairs * x + totalDifferentPairs * y;
    }
    return totalCost;
}
}
