class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            if (prev != null && cur.val == prev.val) {
                prev.next = cur.next;
                cur = cur.next;
                continue;
            }

            prev = cur;
            cur = cur.next;
        }

        return head;
    }
}