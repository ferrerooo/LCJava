class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        
        ListNode tail = getTail(head);

        while (head != tail) {

            ListNode newHead = head.next;
            head.next = tail.next;
            tail.next = head;
            head = newHead;
        }

        return tail;

    }

    private ListNode getTail(ListNode head) {
        while (head.next != null)
            head = head.next;
        
        return head;
    }
}
