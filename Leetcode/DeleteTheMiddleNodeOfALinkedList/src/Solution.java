class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode q = head;
        ListNode s = head, prev = head;

        while (q.next != null) {
            q = q.next;
            if (q.next != null) q = q.next;
            prev = s;
            s = s.next;
        }

        prev.next = s.next;

        return head;
    }
}