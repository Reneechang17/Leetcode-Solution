// Medium
// Custom Sort
// Time:O(nlogn),Space:O(1)
// https://leetcode.cn/problems/reorder-data-in-log-files/

import java.util.Arrays;
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // split identifier and content
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // if all are letter-logs, sort by content
            // if same, sort by identifier
            if (!isDigit1 && !isDigit2) {
                int compare = split1[1].compareTo(split2[1]);
                return compare != 0 ? compare : split1[0].compareTo(split2[0]);
            }

            // if digit-logs, keep original order
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
