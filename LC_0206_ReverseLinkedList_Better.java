lass Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode revHead = null;

        while (head != null) {

            ListNode next = head.next;
            head.next = revHead;
            revHead = head;
            head = next;
        }

        return revHead;

    }
}
