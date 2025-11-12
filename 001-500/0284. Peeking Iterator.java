// Medium
// Iterator
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/peeking-iterator/

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private int peek;
    private boolean nextFlag;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            peek = iterator.next();
            nextFlag = true;
        } else {
            nextFlag = false;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = peek;
        if (iterator.hasNext()) {
            peek = iterator.next();
        } else {
            nextFlag = false;
        }
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return nextFlag;
	}
}
