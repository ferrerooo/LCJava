import java.util.*;

class LC_1472_DesignBrowserHistory {

    private Stack<String> stack;
    private Stack<String> stack2;

    public LC_1472_DesignBrowserHistory(String homepage) {
        stack = new Stack<>();
        stack2 = new Stack<>();
        stack.push(homepage);
    }
    
    public void visit(String url) {
        stack.push(url);
        stack2.clear();
    }
    
    public String back(int steps) {
        for (int i=0; i<steps; i++) {
            if (stack.size() > 1)
                stack2.push(stack.pop());
            else
                break;
        }

        return stack.peek();
    }
    
    public String forward(int steps) {
        for (int i=0; i<steps; i++) {
            if (stack2.size() > 0)
                stack.push(stack2.pop());
            else
                break;
        }

        return stack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */