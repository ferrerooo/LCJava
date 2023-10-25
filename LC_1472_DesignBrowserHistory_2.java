class BrowserHistory {

    private Stack<String> stack;
    private Stack<String> buffer;

    public BrowserHistory(String homepage) {
        
        stack = new Stack<>();
        buffer = new Stack<>();

        stack.push(homepage);
    }
    
    public void visit(String url) {
        
        stack.push(url);
        buffer.clear();

    }
    
    public String back(int steps) {
        
        while (stack.size() > 1 && steps > 0) {
            buffer.push(stack.pop());
            steps --;
        }

        return stack.peek();
    }
    
    public String forward(int steps) {
        
        while (buffer.size() > 0 && steps > 0) {
            stack.push(buffer.pop());
            steps --;
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
