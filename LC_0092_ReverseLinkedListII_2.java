class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode preLeft = preHead;

        ListNode leftNode = getNode(head, left);
        ListNode rightNode = getNode(head, right);

        while (preLeft.next != leftNode) {
            preLeft = preLeft.next;
        }

        while (preLeft.next != rightNode) {

            ListNode curr = preLeft.next;
            preLeft.next = curr.next;
            curr.next = rightNode.next;
            rightNode.next = curr;
        }

        return preHead.next;

    }

    private ListNode getNode(ListNode head, int steps) {

        while (steps > 1) {
            head = head.next;
            steps --;
        }

        return head;
    }
}
