import java.util.*;

public class LC_0225_ImplementStackusingQueues_my2 {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public LC_0225_ImplementStackusingQueues_my2() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        Queue temp = q1;
        q1 = q2;
        q2 = temp;

        return res;
    }
    
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        return q1.peek();
    }
    
    public boolean empty() {
        if (q1.size() >0 || q2.size() > 0) {
            return false;
        }
        return true;
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