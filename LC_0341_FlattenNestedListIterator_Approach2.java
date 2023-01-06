import java.util.*;

    public class LC_0341_FlattenNestedListIterator_Approach2 implements Iterator<Integer> {

        private Deque<NestedInteger> dqueue;
    
        public LC_0341_FlattenNestedListIterator_Approach2(List<NestedInteger> nestedList) {
            dqueue = new LinkedList<>(nestedList);
        }
    
        @Override
        public Integer next() {
            return dqueue.pollFirst().getInteger();
        }
    
        @Override
        public boolean hasNext() {
            if (dqueue.size() == 0)
                return false;
            
            if (dqueue.peekFirst().isInteger())
                return true;
            
            while (dqueue.size() > 0 && !dqueue.peekFirst().isInteger()) {
                List<NestedInteger> list = dqueue.pollFirst().getList();
                if (list != null) {
                    for (int i=list.size()-1; i>=0; i--) {
                        dqueue.offerFirst( list.get(i));
                    }
                }
            }
    
            if (dqueue.size() == 0)
                return false;
            else
                return true;
        }
    }
    
    