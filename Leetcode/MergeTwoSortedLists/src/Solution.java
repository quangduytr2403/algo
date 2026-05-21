class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode head = null, curr = null;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (curr != null) curr.next = list1;
                curr = list1;
                list1 = list1.next;
            }
            else {
                if (curr != null) curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }

            if (head == null) {
                head = curr;
            }
        }

        if (list1 != null) curr.next = list1;
        else curr.next = list2;

        return head;
    }
}