import java.util.*;

public class LC_0341_FlattenNestedListIterator_Approach1 implements Iterator<Integer> {
    
        private List<Integer> list;
        private int cur = 0;
    
        public LC_0341_FlattenNestedListIterator_Approach1(List<NestedInteger> nestedList) {
            
            list = new LinkedList<>();
            
            this.flatten(nestedList, list);
        }
        
        private void flatten(List<NestedInteger> nestedList, List<Integer> list) {
            
            for (NestedInteger ni : nestedList) {
                
                if (ni.isInteger()) {
                    list.add(ni.getInteger());
                } else {
                    List<NestedInteger> nlist = ni.getList();
                    flatten(nlist, list);
                }
            }
        }
    
        @Override
        public Integer next() {
            Integer i = list.get(cur);
            cur += 1;
            return i;
        }
    
        @Override
        public boolean hasNext() {
            return cur < list.size();
        }
    }
    
    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */

    interface NestedInteger {

             // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger();
        
             // @return the single integer that this NestedInteger holds, if it holds a single integer
             // Return null if this NestedInteger holds a nested list
             public Integer getInteger();
        
             // @return the nested list that this NestedInteger holds, if it holds a nested list
             // Return empty list if this NestedInteger holds a single integer
             public List<NestedInteger> getList();
    }