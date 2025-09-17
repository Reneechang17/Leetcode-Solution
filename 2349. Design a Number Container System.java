// Medium
// Map, TreeSet
// https://leetcode.cn/problems/design-a-number-container-system/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class NumberContainers {
    // index -> number
    private Map<Integer, Integer> idxToMap;
    // number -> all indexes set
    private Map<Integer, TreeSet<Integer>> numToIdx;
    
    public NumberContainers() {
        idxToMap = new HashMap<>();
        numToIdx = new HashMap<>();
    }

    // Time:O(nlogn), Space:O(m)
    public void change(int index, int number) {
        if (idxToMap.containsKey(index)) {
            int old = idxToMap.get(index);
            TreeSet<Integer> oldSet = numToIdx.get(old);
            oldSet.remove(index);

            if (oldSet.isEmpty()) {
                numToIdx.remove(old);
            }
        }

        // update
        idxToMap.put(index, number);

        numToIdx.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    // Time:O(nlogn), Space:O(1)
    public int find(int number) {
        if (!numToIdx.containsKey(number) ||
                numToIdx.get(number).isEmpty()) {
            return -1;
        }
        return numToIdx.get(number).first();
    }
}
