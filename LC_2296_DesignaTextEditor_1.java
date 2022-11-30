public class LC_2296_DesignaTextEditor_1 {
    
    private NodeTE head;
    private NodeTE tail;
    private NodeTE cur;
    
    public LC_2296_DesignaTextEditor_1() {
        head = new NodeTE('h');
        tail = new NodeTE('t');
        head.next = tail;
        tail.pre = head;
        cur = head;
    }
    
    public void addText(String text) {
        char[] arr = text.toCharArray();
        for (char c : arr) {
            NodeTE node = new NodeTE(c);
            node.pre = cur;
            node.next = cur.next;
            cur.next.pre = node;
            cur.next = node;
            cur = node;
        }
    }
    
    public int deleteText(int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (cur == head) 
                break;
            NodeTE delNode = cur;
            cur = delNode.pre;
            cur.next = delNode.next;
            cur.next.pre = cur;
            delNode.pre = null;
            delNode.next = null;
            count ++;
        }
        
        return count;
    }
    
    public String cursorLeft(int k) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < k ; i++) {
            if (cur == head)
                break;
            cur = cur.pre;
        }
        
        NodeTE localCur = cur;
        for (int i = 0; i<10; i++) {
            if (localCur == head)
                break;
            sb.append(localCur.val);
            localCur = localCur.pre;
        }
        
        return sb.reverse().toString();
    }
    
    public String cursorRight(int k) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < k ; i++) {
            if (cur.next == tail)
                break;
            cur = cur.next;
        }
        
        NodeTE localCur = cur;
        for (int i = 0; i<10; i++) {
            if (localCur == head)
                break;
            sb.append(localCur.val);
            localCur = localCur.pre;
        }
        
        return sb.reverse().toString();
    }
    
    class NodeTE {
        public char val;
        public NodeTE pre;
        public NodeTE next;
        public NodeTE(char c, NodeTE preNode, NodeTE nextNode) {
            this.val = c;
            this.pre = preNode;
            this.next = nextNode;
        }
        public NodeTE(char c) {
            this.val = c;
            this.pre = null;
            this.next = null;
        }
    }

}
