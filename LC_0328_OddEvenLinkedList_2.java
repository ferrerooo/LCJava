class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return head;
        
        ListNode oddDummy = new ListNode();
        ListNode evenDummy = new ListNode();

        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;

        ListNode odd = head;
        ListNode even = head.next;

        while (odd != null && even != null) {

            ListNode temp = even.next;

            oddTail.next = odd;
            oddTail = oddTail.next;
            oddTail.next = null;

            evenTail.next = even;
            evenTail = evenTail.next;
            evenTail.next = null;

            odd = temp;
            if (odd != null)
                even = odd.next;
            else
                even = null;
        }

        if (odd != null) {
            oddTail.next = odd;
            oddTail = oddTail.next;
        }

        oddTail.next = evenDummy.next;

        return oddDummy.next;

    }
}
