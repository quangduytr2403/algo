class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder s1 = new StringBuilder();

        while(head != null) {
            s1.append(head.val);
            head = head.next;
        }
        String s2 = s1.toString();
        return s1.reverse().toString().equals(s2);
    }
}