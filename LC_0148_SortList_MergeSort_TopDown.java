// https://www.youtube.com/watch?v=M1TwY0nsTZA

class Solution {
    public ListNode sortList(ListNode head) {
        
        if (head == null)
            return null;

        ListNode dummy = new ListNode();
        dummy.next = head;

        return recur(dummy).next;
    }

    private ListNode recur(ListNode preHead) {

        if (preHead.next == null || preHead.next.next == null)
            return preHead;

        ListNode fast = preHead;
        ListNode slow = preHead;

        while (fast != null) {
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        ListNode fastPreHead = new ListNode();
        fastPreHead.next = slow.next;
        slow.next = null;

        ListNode preHead1 = recur(preHead);
        ListNode preHead2 = recur(fastPreHead);

        return merge2lists(preHead1, preHead2);
    }

    private ListNode merge2lists(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        ListNode p1 = h1.next;
        ListNode p2 = h2.next;

        while (p1 != null && p2 != null) {

            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }

            p = p.next;
        }

        if (p1 == null) {
            p.next = p2;
        } else {
            p.next = p1;
        }

        return dummy;
    }
}
