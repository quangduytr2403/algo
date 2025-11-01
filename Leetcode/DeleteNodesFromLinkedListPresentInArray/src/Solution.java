import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        ListNode cur = head;
        ListNode newHead = null;
        ListNode prev = null;
        while (cur != null) {
            if (s.contains(cur.val)) {
            } else {
                if (newHead == null) {
                    newHead = cur;
                    prev = cur;
                } else {
                    prev.next = cur;
                    prev = cur;
                }
            }

            cur = cur.next;
        }
        prev.next = null;

        return newHead;
    }
}