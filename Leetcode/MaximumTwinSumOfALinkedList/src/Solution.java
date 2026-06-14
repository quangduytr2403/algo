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
    public int pairSum(ListNode head) {
        List<Integer> l = new ArrayList<>();

        while (head != null) {
            l.add(head.val);
            head = head.next;
        }

        int res = 0;
        for (int i = 0; i < l.size() / 2; i++) res = Math.max(res, l.get(i) + l.get(l.size() - 1 - i));

        return res;
    }
}