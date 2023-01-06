import java.util.*;

public class LC_0716_MaxStack {
    
    private Node head;
    private Node tail;
    private TreeMap<Integer, List<Node>> treemap;

    public LC_0716_MaxStack() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
        treemap = new TreeMap<>();
    }
    
    public void push(int x) {
        Node n = new Node(x);
        n.next = tail;
        n.pre = tail.pre;
        n.pre.next = n;
        tail.pre = n;
        if(!treemap.containsKey(x)) {
            treemap.put(x, new ArrayList<Node>());
        }
        treemap.get(x).add(n);
    }
    
    public int pop() {
        Node del = tail.pre;
        tail.pre = del.pre;
        del.pre.next = tail;
        
        List<Node> list = treemap.get(del.val);
        list.remove(list.size()-1);
        if (list.size() == 0)
            treemap.remove(del.val);

        return del.val;
    }
    
    public int top() {
        return tail.pre.val;
    }
    
    public int peekMax() {
        return treemap.lastKey();
    }
    
    public int popMax() {
        Map.Entry<Integer, List<Node>> entry = treemap.lastEntry();
        List<Node> list = entry.getValue();
        Node last = list.get(list.size()-1);
        list.remove(list.size()-1);
        if (list.size() == 0)
            treemap.remove(entry.getKey());
        
        last.next.pre = last.pre;
        last.pre.next = last.next;
        return last.val;
    }

    class Node {

        public int val = 0;
        public Node pre = null;
        public Node next = null;
        public Node(int v) {
            this.val = v;
        }

    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */