// Hard
// Merge Sort
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/

class Solution {
    public int reversePairs(int[] record) {
        if (record == null || record.length < 2) return 0;
        return mergeSort(record, 0, record.length - 1);
    }
    private int mergeSort(int[] record, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int cnt = mergeSort(record, left, mid) + mergeSort(record, mid + 1, right);

        // count the reverse pairs
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && record[i] > record[j]) {
                j++;
            }
            cnt += (j - (mid + 1));
        }

        // merge two halves
        int[] tmp = new int[right - left + 1];
        int i = left, k = 0, l = mid + 1;
        while (i <= mid && l <= right) {
            if (record[i] <= record[l]) {
                tmp[k++] = record[i++];
            } else {
                tmp[k++] = record[l++];
            }
        }
        while (i <= mid) {
            tmp[k++] = record[i++];
        }
        while (l <= right) {
            tmp[k++] = record[l++];
        }
        System.arraycopy(tmp, 0, record, left, tmp.length);
        return cnt;
    }
}

// 逆序对：数组中两个元素i和j，如果i<j且arr[i]>arr[j]，则(arr[i], arr[j])是一个逆序对
// 归并排序，在排序过程中比较左右两部分的元素，如果左侧元素大于右侧 -> 逆序对
// => Time:O(nlgn) 
