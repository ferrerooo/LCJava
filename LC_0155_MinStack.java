class MinStack {

    private Stack<Integer> s;
    private Stack<Integer> smin;

    public MinStack() {
        s = new Stack<>();
        smin = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);

        if (smin.size() == 0)
            smin.push(val);
        else{
            int cur = smin.peek();
            if (val < cur)
                smin.push(val);
            else
                smin.push(cur);
        }
    }
    
    public void pop() {
        s.pop();
        smin.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return smin.peek();
    }
}
