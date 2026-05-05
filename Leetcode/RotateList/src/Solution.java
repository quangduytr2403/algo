class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode tail = head, curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.next;
            if (curr != null) tail = curr;
        }
        k = k % count;
        k = count - k;
        if (k == 0) return head;
        curr = head;
        while (k > 1) {
            k--;
            curr = curr.next;
        }

        tail.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }
}