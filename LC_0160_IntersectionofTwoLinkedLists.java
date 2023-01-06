public class LC_0160_IntersectionofTwoLinkedLists {public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    ListNode a = headA;
    int cnta = 1;
    ListNode b = headB;
    int cntb = 1;

    while (a.next != null) {
        a = a.next;
        cnta++;
    }

    while (b.next != null) {
        b = b.next;
        cntb++;
    }

    if (a != b)
        return null;
    
    if (cnta > cntb) {
        for (int i=0; i<cnta-cntb; i++) {
            headA = headA.next;
        }
    } else if (cnta<cntb) {
        for (int i=0; i<cntb-cnta; i++) {
            headB = headB.next;
        }
    }

    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }

    return headB;
    
}
}