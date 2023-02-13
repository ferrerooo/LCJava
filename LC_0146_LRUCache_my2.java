import java.util.*;

public class LC_0146_LRUCache_my2 {
    private class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int _k, int _v) {
            key = _k;
            val = _v;
        }
    }

    private int max;
    private int count;
    Node head;
    Node tail;
    Map<Integer, Node> map ;

    public LC_0146_LRUCache_my2(int capacity) {
        max = capacity;
        count = 0;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);
        cur.next.pre = cur.pre;
        cur.pre.next = cur.next;

        cur.next = tail;
        cur.pre = tail.pre;
        cur.pre.next = cur;
        tail.pre = cur;

        return cur.val;
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            cur.next.pre = cur.pre;
            cur.pre.next = cur.next;

            cur.next = tail;
            cur.pre = tail.pre;
            cur.pre.next = cur;
            tail.pre = cur;
        } else {
            count++;
            Node newnode = new Node(key, value);
            map.put(key, newnode);
            newnode.next = tail;
            newnode.pre = tail.pre;
            newnode.pre.next = newnode;
            newnode.next.pre = newnode;

            if (count > max) {
                Node rev = head.next;
                head.next = rev.next;
                rev.next.pre = head;
                map.remove(rev.key);
                count--;
            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */