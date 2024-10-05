// Medium
// Stack
// O(n)
// https://leetcode.com/problems/flatten-nested-list-iterator/

import java.util.*;

class Solution {
    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return stack.pop().getInteger();
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger current = stack.peek();
                if (current.isInteger()) {
                    return true;
                }
                stack.pop();
                List<NestedInteger> list = current.getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
            return false;
        }
    }
}

/**
 * 嵌套迭代器：實現一個嵌套迭代器，可以對嵌套的整數列表進行迭代
 * 
 * 思路：這題看起來很像括號那題，所以可以嘗試看看用Stack
 * 具體做法是將nestInteger列表用逆序的方式壓入棧（因為棧是先進後出的），這樣可以保證元素之後的順序是正確的
 * 在next方法中，我們需要判斷棧頂元素是不是整數，如果是整數就返回並且用getInteger方法拿到那個數，如果不是返回null
 * 而hasNext方法中，如果棧不為空，則每次循環都將棧頂元素拿出，檢查他是不是整數，如果是整數就返回true，否則他就是列表
 * 那我們需要把列表拿出來，將裡面的元素逆序入棧
 **/