

import java.util.*;

class LC_0146_LRUCache {
    
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    
    public LC_0146_LRUCache(int capacity) {
        
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.pre = null;
        this.head.next = tail;
        this.tail.pre = head;
        this.tail.next = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        if (map.containsKey(key)) {
            this.update(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
            map.get(key).val = value;
            this.update(map.get(key));
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            map.put(key, newNode);
            this.insert(newNode);
            
            if (map.size() > capacity) {
                Node delNode = head.next;
                map.remove(delNode.key);
                delNode.next.pre = head;
                head.next = delNode.next;
            }
        } 
    }
    
    private void insert(Node node) {
        
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
        
    }
    
    private void update(Node node) {
        
        node.next.pre = node.pre;
        node.pre.next = node.next;
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
    }
    
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */