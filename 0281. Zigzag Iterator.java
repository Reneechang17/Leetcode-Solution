// Medium
// Design, Iterator
// Time:O(n+m), Space:O(n+m)
// https://leetcode.cn/problems/zigzag-iterator/

import java.util.*;

class ZigzagIterator {
    private List<Integer> list;
    private int index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<Integer>();
        int size1 = v1.size(), size2 = v2.size();
        int minSize = Math.min(size1, size2);

        // zigzag add the element to list
        for (int i = 0; i < minSize; i++) {
            list.add(v1.get(i));
            list.add(v2.get(i));
        }

        // if size1 > size2, add remaining 
        if (size1 > size2) {
            for (int i = size2; i < size1; i++) {
                list.add(v1.get(i));
            }
        } else if (size1 < size2) {
            for (int i = size1; i < size2; i++) {
                list.add(v2.get(i));
            }
        }
        index = 0;
    }

    public int next() {
        int e = list.get(index);
        index++;
        return e;
    }

    public boolean hasNext() {
        return index < list.size();
    }
}
