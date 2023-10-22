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

/*
ublic class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = this.getLen(headA);
        int lenB = this.getLen(headB);

        ListNode a = headA;
        ListNode b = headB;

        int diff = 0;

        if (lenA > lenB) {
            diff = lenA - lenB;
            for (int i=0; i<diff; i++) {
                a = a.next;
            }
        } else if (lenA < lenB) {
            diff = lenB - lenA;
            for (int i=0; i<diff; i++) {
                b = b.next;
            }
        }

        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }

    private int getLen(ListNode n) {
        if (n == null)
            return 0;
        int len = 0;
        while (n!= null) {
            len++;
            n = n.next;
        }
        return len;
    }
}
*/
