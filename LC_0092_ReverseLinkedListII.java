class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (left == right)
            return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode tail = head;

        for (int i=1; i<right; i++) {
            tail = tail.next;
        }

        ListNode pre = dummy;
        ListNode cur = head;

        for (int i=1; i<left; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        while (pre.next != tail) {
            pre.next = cur.next;
            cur.next = tail.next;
            tail.next = cur;
            cur = pre.next;
        }

        return dummy.next;
    }
}
