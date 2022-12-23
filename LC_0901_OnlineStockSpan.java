import java.util.*;

public class LC_0901_OnlineStockSpan {

    private Stack<int[]> stack;

    public LC_0901_OnlineStockSpan() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        
        int res = 1;

        while (stack.size() > 0 && price >= stack.peek()[0]) {
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
        return res;
    }
    
}
