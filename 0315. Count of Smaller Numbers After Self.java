// Hard
// https://leetcode.cn/problems/count-of-smaller-numbers-after-self/

import java.util.*;

// 返回的新數組中，每個元素是nums[i]右側小於nums[i]的元素數量

class Solution1 {
    // BinarySearch: 數據量中等、對重複元素有明確要求
    // 對於重複元素，會插入到最左側的位置
    // Time:O(n logn), Space:O(n)
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] res = new Integer[n];
        List<Integer> sortedList = new ArrayList<>();

        // 右到左遍歷數組
        for (int i = n - 1; i >= 0; i--) {
            int insertPos = binarySearch(sortedList, nums[i]);
            res[i] = insertPos;
            sortedList.add(insertPos, nums[i]); // 把當前元素插入已排序的列表
        }
        return Arrays.asList(res);
    }

    private int binarySearch(List<Integer> list, int target) {
        if (list.isEmpty())
            return 0;
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
// -----------------------------------------------------------
class Solution2 {
    // MergeSort: 數據量大、穩定
    // Time:O(n logn), Space:O(n)

    private int[] res;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        res = new int[n];

        // 包含索引和值的數組
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i; // 原始索引
            arr[i][1] = nums[i]; // 值
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int x : res) {
            result.add(x);
        }
        return result;
    }

    private void mergeSort(int[][] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[][] arr, int left, int mid, int right) {
        int[][] tmp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            // 當左側元素小於右側元素的時候->計算當前右側小於它的元素個數
            if (arr[i][1] <= arr[j][1]) {
                res[arr[i][0]] += (j - (mid + 1));
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        // 處理剩餘
        while (i <= mid) {
            res[arr[i][0]] += (j - (mid + 1));
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (int p = 0; p < tmp.length; p++) {
            arr[left + p] = tmp[p];
        }
    }
}

// -----------------------------------------------------------
class Solution3 {
    // BIT: 離散化處理，將原始數據映射到連續的排名空間，可以減少樹狀數組的大小
    // Time:O(n logn), Space:O(n)
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];

        int[] sortedNum = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNum);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 0;
        for (int num : sortedNum) {
            if (!ranks.containsKey(num)) {
                ranks.put(num, rank++);
            }
        }

        BIT tree = new BIT(ranks.size());
        for (int i = n - 1; i >= 0; i--) {
            int curRank = ranks.get(nums[i]);
            result[i] = tree.prefix(curRank - 1);

            tree.update(curRank, 1);
        }
        return Arrays.asList(result);
    }
}

class BIT {
    private int[] arr;

    public BIT(int size) {
        arr = new int[size + 1];
    }

    public void buildFromArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        // 構建樹狀數組
        for (int i = 1; i < arr.length; i++) {
            int j = i + (i & -1);
            if (j < arr.length) {
                arr[j] += arr[i];
            }
        }
    }

    // update: 在index位置添加delta
    public void update(int i, int del) {
        i += 1;
        while (i < arr.length) {
            arr[i] += del;
            i += (i & -i);
        }
    }

    // set: 將index位置設為val
    public void setValue(int i, int val) {
        i += 1;
        int del = val - arr[i];
        update(i, del);
    }

    // prefix: 計算[0, index]的元素和
    public int prefix(int i) {
        if (i < 0) return 0;
        i += 1;
        int sum = 0;
        while (i > 0) {
            sum += arr[i];
            i -= (i & -i);
        }
        return sum;
    }
}
