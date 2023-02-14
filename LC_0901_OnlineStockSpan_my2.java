import java.util.*;

public class LC_0901_OnlineStockSpan_my2 {
    
    private Stack<Integer> stack ;
    private List<Integer> list;

    public LC_0901_OnlineStockSpan_my2() {
        
        stack = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        
        list.add(price);

        while (stack.size() > 0 && list.get(stack.peek()) <= price) {
            stack.pop();
        }

        int ans = stack.size() == 0 ? list.size() : list.size()-1-stack.peek();

        stack.push(list.size()-1);

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */