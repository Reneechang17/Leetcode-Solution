// Medium
// DFS, Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/flatten-nested-list-iterator/

import java.util.*;
class Solution {
    public class NestedIterator implements Iterator<Integer> {
        private List<Integer> res;
        private int depth;
    
        public NestedIterator(List<NestedInteger> nestedList) {
            res = new ArrayList<>();
            depth = 0;
            dfs(nestedList);
        }
    
        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    res.add(ni.getInteger());
                } else {
                    dfs(ni.getList());
                }
            }
        }
    
        @Override
        public Integer next() {
            return res.get(depth++);
        }
    
        @Override
        public boolean hasNext() {
            return depth < res.size();
        }
    }
}
