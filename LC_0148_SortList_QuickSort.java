public class LC_0148_SortList {
    
    public ListNode sortList(ListNode head) {

        ListNode dummy = new ListNode(-111);
        dummy.next = head;
        this.recur(dummy, null);
        return dummy.next;
    }

    private void selectSplitPoint(ListNode dummy, ListNode end){

        ListNode fast = dummy.next;
        ListNode slow = dummy.next;

        while (fast != end) {
            fast = fast.next;
            if (fast != end) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        int temp = dummy.next.val;
        dummy.next.val = slow.val;
        slow.val = temp;
    }

    private void recur(ListNode dummy, ListNode end) {

        if (dummy == end || dummy.next == end || dummy.next.next == end)
            return;
        
        this.selectSplitPoint(dummy, end);

        // taken dummy.next as the point to split the list
        ListNode splitPoint = dummy.next;

        ListNode p1 = dummy.next;
        ListNode p2 = dummy.next.next;

        //System.out.println("p2:"+p2.val+", p1:"+p1.val+", splitPoint:"+splitPoint.val+", dummy:"+dummy.val+", end:"+end);

        while (p2 != end ) {
            
            if (p2.val >= splitPoint.val) {
                p2 = p2.next;
                p1 = p1.next;
            } else {
                p1.next = p2.next;
                p2.next = dummy.next;
                dummy.next = p2;
                p2 = p1.next;
            }
        }

        this.recur(dummy, splitPoint);
        this.recur(splitPoint, end);
    }
}
