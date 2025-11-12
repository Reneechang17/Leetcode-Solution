// Hard
// Recursion
// Time:O(5^m/2 + 5^n/2), Space:O(5^m/2 + 5^n/2)
// https://leetcode.cn/problems/strobogrammatic-number-iii/

import java.util.*;

class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int lowLength = low.length(), highLength = high.length();
        if (lowLength > highLength || lowLength == highLength && low.compareTo(high) > 0) {
            return 0;
        }
        if (lowLength == highLength) {
            List<String> res = helper(lowLength);
            int lowIndex = binarySearch(res, low), highIndex = binarySearch(res, high);
            if (lowIndex < 0) {
                lowIndex = -lowIndex - 1;
            }
            if (highIndex < 0) {
                highIndex = -highIndex - 2;
            }
            return highIndex - lowIndex + 1;
        } else {
            int count = 0;
            for (int i = lowLength + 1; i < highLength; i++) {
                count += countHelper(i);
            }
            List<String> lowList = helper(lowLength);
            List<String> highList = helper(highLength);
            int lowIndex = binarySearch(lowList, low);
            if (lowIndex < 0) {
                lowIndex = -lowIndex - 1;
            }
            count += lowList.size() - lowIndex;
            int highIndex = binarySearch(highList, high);
            if (highIndex < 0) {
                highIndex = -highIndex - 2;
            }
            count += highIndex + 1;
            return count;
        }
    }

    public int countHelper(int n) {
        if (n == 1) {
            return 3;
        } else if (n == 2) {
            return 4;
        } else if (n == 3) {
            return 12;
        } else {
            if (n % 2 == 0) {
                int diff = n - 2;
                return 4 * (int)Math.pow(5, diff / 2);
            } else {
                int diff = n - 3;
                return 12 * (int)Math.pow(5, diff / 2);
            }
        }
    }

    public int binarySearch(List<String> list, String key) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            String str = list.get(mid);
            if (str.equals(key)) {
                return mid;
            } else if (str.compareTo(key) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -low - 1;
    }

    public List<String> helper(int n) {
        List<String> res = helperFindZero(n);
        if (n == 1) {
            return res;
        }
        int size = res.size();
        for (int i = size - 1; i >= 0; i--) {
            if (res.get(i).charAt(0) == '0') {
                res.remove(i);
            }
        }
        Collections.sort(res);
        return res;
    }

    public List<String> helperFindZero(int n) {
        Queue<String> que = new LinkedList<String>();
        int start = n % 2 == 1 ? 1 : 2;
        if (start == 1) {
            que.offer("0");
            que.offer("1");
            que.offer("8");
        } else {
            que.offer("00");
            que.offer("11");
            que.offer("69");
            que.offer("88");
            que.offer("96");
        }
        for (int i = start; i < n; i += 2) {
            int size = que.size();
            for (int j = 0; j < size; j++) {
                String prev = que.poll();
                que.offer("0" + prev + "0");
                que.offer("1" + prev + "1");
                que.offer("6" + prev + "9");
                que.offer("8" + prev + "8");
                que.offer("9" + prev + "6");
            }
        }
        List<String> res = new ArrayList<String>();
        while (!que.isEmpty()) {
            res.add(que.poll());
        }
        return res;
    }
}
