import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> l = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            l.add(tmp);
            tmp = tmp.next;
        }

        int index = l.size() - 1 - n;
        if (index == -1) return head.next;
        l.get(index).next = l.get(index).next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        Solution s = new Solution();
        ListNode res = s.removeNthFromEnd(l1, 2);
        System.out.println(res.val);
    }
}