import java.util.*;

public class LC_0901_OnlineStockSpan_MyIdea {
    private Stack<int[]> stack;
    private int index;

    public LC_0901_OnlineStockSpan_MyIdea() {
        stack = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        
        index ++;
        int res = 0;
        
        if (stack.size() == 0 || price < stack.peek()[0]) {
            res = 1;
        } else {
            while (stack.size() > 0 && price >= stack.peek()[0]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                res = index + 1;
            } else {
                res = index - stack.peek()[1];
            }
        }

        stack.push(new int[]{price, index});

        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */