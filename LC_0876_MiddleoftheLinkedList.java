class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null) {
            p2 = p2.next;

            if (p2.next != null) 
                p2 = p2.next;
            p1 = p1.next;
            
        }

        return p1;
    }
}
