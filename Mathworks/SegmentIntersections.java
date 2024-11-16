package Mathworks;

/** Segment Intersections
 * 给定n条线段，每条线段i由两个整数startsAt[i]和endsAt[i]描述。每条线段覆盖从startsAt[i]到endsAt[i]的所有点。
 * 我们需要计算对于每条线段i（其中 0≤i<n），与其相交的其他线段数量。相交的定义是两条线段之间有至少一个共同点。
 * 
 * 1. 将线段的起点和终点做排序，以快速确定有多少线段的起始或结束在指定点之前或是之后，可以快速计算重叠数量
 * 2. 计算重叠的线段数量：对于每个线段，获取其起始s和结束e为止，分别找终点在s之前，起点在e之后的线段数量
 * 3. 计算重叠数量：根据线段总数，排除在起点s之前和在终点e之后的线段数量，再减去当前线段的自身
 * Note: 由于这题的数据量比较大，为了更高效的在排序数组中找到满足条件的位置，可以使用二分查找
 * 
 * Given n segments, each segment i is described by two integers, startsAt[i] and endsAt[i]. Each segment covers all points from startsAt[i] to endsAt[i].
We need to calculate, for each segment i, the number of other segments that intersect with it. 
Intersection is defined as having at least one common point between two segments.

1. Sort the start and end points of the segments, which allow us to quickly determine how many segments start or end before or after a given point
2. Calculate the number of overlapping segments: For each segment we get its start s and end e, and find the count of segments with endpoints before s and starting points after e.
3. Calculate the intersection count: Based on the total number of segments, exclude those ending before s and starting after e, then subtract one for the segment itself.
Note: Since this problem involves large datasets, so binary search will be efficient way to locate the positions in the sorted arrays

 * time O(nlogn):loop n times, and each time we do binary search, so it's nlogn
 * space O(n): sorting need O(n) space, and result list need O(n) space, overall is O(n)
 */

import java.util.*;

class Solution {
    public class SegmentIntersections {
        public static List<Integer> countIntersections(List<Integer> startsAt, List<Integer> endsAt) {
            // get the number of segments
            int n = startsAt.size();

            // use two arrays to store the sorted start and end points
            int[] starts = new int[n];
            int[] ends = new int[n];

            // copy the values from startsAt and endsAt to the arrays
            for (int i = 0; i < n; i++) {
                starts[i] = startsAt.get(i);
                ends[i] = endsAt.get(i);
            }

            // sort the two arrays for binary search
            Arrays.sort(starts);
            Arrays.sort(ends);

            // use list to store overlapping segments count for each segment
            List<Integer> res = new ArrayList<>();

            // 对每条线段计算与其重叠的其他线段数量
            // for each segment, calculate the number of other intersection
            for (int i = 0; i < n; i++) {
                int s = startsAt.get(i);
                int e = endsAt.get(i);

                // calculate the number of segments with endpoints before the current start point
                // and starting points after the current end point
                int beforeStart = lowerBound(ends, s);
                int afterEnd = n - upperBound(starts, e);

                // intersection count: total count - before start and after end count - current segment
                int count = n - beforeStart - afterEnd - 1;

                res.add(count);
            }
            return res;
        }

        // use binary search to efficient find the first element greater than key
        private static int lowerBound(int[] arr, int key) {
            int left = 0, right = arr.length;
            // 二分的范围在[left, right]
            while (left < right) {
                int mid = (left + right) >> 1;
                if (arr[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        // use binary search to efficient find the first element greater than or equal to key
        private static int upperBound(int[] arr, int key) {
            int left = 0, right = arr.length;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (arr[mid] <= key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        List<Integer> startsAt1 = Arrays.asList(1, 2, 3);
        List<Integer> endsAt1 = Arrays.asList(3, 4, 5);
        List<Integer> result1 = SegmentIntersections.countIntersections(startsAt1, endsAt1);
        System.out.println("Test Case 1:");
        for (int count : result1) {
            System.out.println(count);
        }
        // Expected output: [2, 2, 2]

        // Test Case 2
        List<Integer> startsAt2 = Arrays.asList(1, 5, 8);
        List<Integer> endsAt2 = Arrays.asList(4, 10, 12);
        List<Integer> result2 = SegmentIntersections.countIntersections(startsAt2, endsAt2);
        System.out.println("Test Case 2:");
        for (int count : result2) {
            System.out.println(count);
        }
        // Expected output: [0, 1, 1]
        
        // Test Case 3
        List<Integer> startsAt3 = Arrays.asList(1, 5, 10);
        List<Integer> endsAt3 = Arrays.asList(2, 6, 11);
        List<Integer> result3 = SegmentIntersections.countIntersections(startsAt3, endsAt3);
        System.out.println("Test Case 3:");
        for (int count : result3) {
            System.out.println(count);
        }
        // Expected output: [0, 0, 0]
    }
}
