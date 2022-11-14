// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.*;

class LC_0284_PeekingIterator implements Iterator<Integer> {
    
    private Integer peekVal = null;
    private Iterator<Integer> iter = null;
    
	public LC_0284_PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        
        if (this.peekVal != null)
            return this.peekVal;
        
        if (this.iter.hasNext()) {
            this.peekVal = this.iter.next();
        } else {
            return null;
        }
        
        return this.peekVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    
        Integer result = null;
        if (this.peekVal != null) {
            result = this.peekVal;
            this.peekVal = null;
        } else {
            result = this.iter.next();
        }
        
        return result;
	}
	
	@Override
	public boolean hasNext() {
	    
        if (this.peekVal != null)
            return true;
        else
            return this.iter.hasNext();
	}
}