import java.util.*;

public class LC_0225_ImplementStackusingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public LC_0225_ImplementStackusingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        if (this.empty()) {
            throw new RuntimeException("empty stack");
        }

        if (q1.size() == 0) {
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        return q1.poll();
    }
    
    public int top() {
        if (this.empty()) {
            throw new RuntimeException("empty stack");
        }

        if (q1.size() == 0) {
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        return q1.peek();
    }
    
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */