import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> s = new HashSet<>();
        ListNode cur = headA;

        while (cur != null) {
            s.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (s.contains(cur)) return cur;
            cur = cur.next;
        }

        return null;
    }
}